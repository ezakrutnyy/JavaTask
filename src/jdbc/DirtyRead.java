package jdbc;

import jdbc.connections.JdbcTmConnection;
import jdbc.dao.ProductAccountingDao;
import jdbc.entity.ProductAccountingEntity;
import jdbc.repository.ProductAccountingJDBCDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class DirtyRead {
    public static void main(String[] args) throws InterruptedException {

        try {

            final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();
            connection.setAutoCommit(false);
            ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(connection);

            // todo оракл не поддурживает
            //spring.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);


            ProductAccountingEntity prodAccounting = productAccountingDao.getByPrimaryKey(1L).orElseThrow(() ->
                    new RuntimeException("ProductAccountingEntity not found!"));

            System.out.println("MainThread prodAccounting before update: " + prodAccounting);

            prodAccounting.setAmount(new BigDecimal(777));
            productAccountingDao.update(prodAccounting);

            new FoneThread().start();

            Thread.sleep(3000);

            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    static class FoneThread extends Thread {

        @Override
        public void run() {
            try {
                final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();
                connection.setAutoCommit(false);
                ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(connection);

                // todo оракл не поддурживает
                //spring.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                ProductAccountingEntity prodAccounting = productAccountingDao.getByPrimaryKey(1L).orElseThrow(() ->
                        new RuntimeException("ProductAccountingEntity not found!"));
                System.out.println("FoneThread prodAccounting: " + prodAccounting);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


