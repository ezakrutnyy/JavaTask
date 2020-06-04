package jdbc.service;

import jdbc.connections.HibernateTmConnection;
import jdbc.connections.JdbcTmConnection;
import jdbc.dao.ProductAccountingDao;
import jdbc.entity.ProductAccountingEntity;
import jdbc.repository.ProductAccountingHibernateDao;
import jdbc.repository.ProductAccountingJDBCDao;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductAccountingService {

    public static void main(String[] args) {

        /*  jdbc */
//        final Connection jdbcConnection = (Connection) JdbcTmConnection.getInstance().connect();
//        final ProductAccountingDao productAccountingDao = new ProductAccountingJDBCDao(jdbcConnection);


        /* hibernate */
        final Session session = (Session) HibernateTmConnection.getInstance().connect();
        final ProductAccountingDao productAccountingDao = new ProductAccountingHibernateDao(session);

        ProductAccountingEntity productAccounting1 = new ProductAccountingEntity();
        productAccounting1.setProductAccountingType("DEBIT_AGGREGATION");
        productAccounting1.setProductAccountingStatus("NEW");
        productAccounting1.setAmount(new BigDecimal(555));
        productAccounting1.setCurrency("810");
        productAccounting1.setCreateDate(new Date());

        ProductAccountingEntity productAccounting2 = new ProductAccountingEntity();
        productAccounting2.setProductAccountingType("CREDIT_AGGREGATION");
        productAccounting2.setProductAccountingStatus("NEW");
        productAccounting2.setAmount(new BigDecimal(444));
        productAccounting2.setCurrency("810");
        productAccounting2.setCreateDate(new Date());

        // insert
        productAccountingDao.insert(productAccounting1);
        productAccountingDao.insert(productAccounting2);

        session.close();
    }

}
