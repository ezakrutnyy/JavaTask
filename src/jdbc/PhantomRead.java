package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.ProductAccountingDao;
import jdbc.entity.ProductAccountingEntity;
import jdbc.repository.ProductAccountingJDBCDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class PhantomRead {

    public static void main(String[] args) {
        try {
            final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            final ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(connection);

            List<ProductAccountingEntity> prodAccountingList = productAccountingDao.getAll();

            System.out.println("MainThread prodAccounting before insert: " + prodAccountingList);

            new PhantomRead.FoneThread().start();

            Thread.sleep(2000);

            prodAccountingList = productAccountingDao.getAll();
            System.out.println("MainThread prodAccounting after insert: " + prodAccountingList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FoneThread extends Thread {
        @Override
        public void run() {
            try {
                final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                final ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(connection);


                ProductAccountingEntity prodAccounting = new ProductAccountingEntity();
                prodAccounting.setProductAccountingId(100L);
                prodAccounting.setProductAccountingType("DEBIT_AGGREGATION");
                prodAccounting.setProductAccountingStatus("NEW");
                prodAccounting.setAmount(new BigDecimal(777));
                prodAccounting.setCurrency("978");
                prodAccounting.setCreateDate(new Date());
                productAccountingDao.insert(prodAccounting);

                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
