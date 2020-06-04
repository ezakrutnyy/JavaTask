package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.ProductAccountingDao;
import jdbc.entity.ProductAccountingEntity;
import jdbc.repository.ProductAccountingJDBCDao;

import java.math.BigDecimal;
import java.sql.Connection;

public class NonRepeatableRead {

    public static void main(String[] args) {
        try {

            final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            final ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(connection);

            ProductAccountingEntity prodAccounting = productAccountingDao.getByPrimaryKey(1L).orElseThrow(() ->
                    new RuntimeException("ProductAccountingEntity not found!"));

            System.out.println("MainThread prodAccounting before update: " + prodAccounting);

            new NonRepeatableRead.FoneThread().start();

            Thread.sleep(2000);

            prodAccounting = productAccountingDao.getByPrimaryKey(1L).orElseThrow(() ->
                    new RuntimeException("ProductAccountingEntity not found!"));
            System.out.println("MainThread prodAccounting after update: " + prodAccounting);

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

                ProductAccountingEntity prodAccounting = productAccountingDao.getByPrimaryKey(1L).orElseThrow(() ->
                        new RuntimeException("ProductAccountingEntity not found!"));

                prodAccounting.setAmount(new BigDecimal(333));
                productAccountingDao.update(prodAccounting);

                connection.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
