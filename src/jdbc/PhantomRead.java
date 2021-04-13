package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import jdbc.repository.OfferJdbcDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class PhantomRead {

    public static void main(String[] args) {
        try {
            final Connection connection = JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            final OfferDao dao = new OfferJdbcDao(connection);

            List<OfferEntity> offers = dao.getAll();
            System.out.println("MainThread offers before insert: " + offers);

            new PhantomRead.FoneThread().start();

            Thread.sleep(2000);

            offers = dao.getAll();
            System.out.println("MainThread offers after insert: " + offers);


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

                OfferEntity offer = new OfferEntity();
                offer.setId(300L);
                offer.setCategory("Device");
                offer.setTitle("IPhone 6S");
                offer.setDescription("Sell Iphone 6S");
                offer.setPrice(new BigDecimal(6500));
                offer.setCreateDate(new Date());
                offer.setUserId(8L);
                dao.insert(offer);

                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
