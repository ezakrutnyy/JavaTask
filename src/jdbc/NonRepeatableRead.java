package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import jdbc.repository.OfferJdbcDao;

import java.math.BigDecimal;
import java.sql.Connection;

public class NonRepeatableRead {

    public static void main(String[] args) {
        try {

            final Connection connection = JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            final OfferDao dao = new OfferJdbcDao(connection);

            OfferEntity offer = dao.getByPrimaryKey(10L).orElseThrow(() ->
                    new RuntimeException("Offer not found!"));

            System.out.println("MainThread offer before update: " + offer);

            new NonRepeatableRead.FoneThread().start();

            Thread.sleep(2000);

            offer = dao.getByPrimaryKey(10L).orElseThrow(() ->
                    new RuntimeException("Offer not found!"));
            System.out.println("MainThread offer after update: " + offer);

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FoneThread extends Thread {
        @Override
        public void run() {
            try {
                final Connection connection = JdbcTmConnection.getInstance().connect();
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

                final OfferDao dao = new OfferJdbcDao(connection);
                OfferEntity offer = dao.getByPrimaryKey(10L).orElseThrow(() ->
                        new RuntimeException("Offer not found!"));
                offer.setPrice(new BigDecimal(333));
                dao.update(offer);

                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
