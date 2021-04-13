package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import jdbc.repository.OfferJdbcDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class DirtyRead {
    public static void main(String[] args) throws InterruptedException {
        try {
            final Connection connection = JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            OfferDao offerDao = new OfferJdbcDao(connection);

            OfferEntity offer = offerDao.getByPrimaryKey(10L).orElseThrow(() ->
                    new RuntimeException("Offer not found!"));

            System.out.println("MainThread offer before update: " + offer);
            offer.setPrice(new BigDecimal(22_222));
            offerDao.update(offer);

            // 2 thread
            new Thread(new FoneThread()).start();

            Thread.sleep(6000);

            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static class FoneThread implements Runnable {

        @Override
        public void run() {
            try {
                final Connection connection = JdbcTmConnection.getInstance().connect();
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                OfferDao offerDao = new OfferJdbcDao(connection);

                OfferEntity offer = offerDao.getByPrimaryKey(10L).orElseThrow(() ->
                        new RuntimeException("Offer not found!"));
                System.out.println("FoneThread offer: " + offer);
                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


