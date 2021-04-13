package jdbc.service;

import jdbc.connections.HibernateTmConnection;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import jdbc.repository.OfferHibernateDao;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class OfferService {

    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws SQLException, ParseException {

        /*  jdbc */
//        final Connection jdbcConnection = JdbcTmConnection.getInstance().connect();
//        final OfferDao repository = new OfferJdbcDao(jdbcConnection);

        final Session session = HibernateTmConnection.getInstance().openSession();
        final OfferDao repository = new OfferHibernateDao(session);

        /* getAll() */
        System.out.println(" getAll() ");
        List<OfferEntity> offers = repository.getAll();
        System.out.println(offers);

        /* insert () */
        System.out.println(" insert() ");
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(100L);
        offerEntity.setCategory("Auto");
        offerEntity.setTitle("Toyota Rav 4 2018");
        offerEntity.setDescription("Buy Toyota Rav 4 2018, automat, 220 strong, Moscow");
        offerEntity.setPrice(new BigDecimal(1_600_000));
        offerEntity.setCreateDate(format.parse("06.04.2021"));
        offerEntity.setUserId(8L);
        repository.insert(offerEntity);
//
        /* getByPrimaryKey() */
        System.out.println(" getByPrimaryKey() ");
        Optional<OfferEntity> offerEntityOptional = repository.getByPrimaryKey(10L);
        offerEntityOptional.ifPresent(System.out::println);


        /* update() */
        System.out.println(" update() ");
        offerEntity.setDescription(offerEntity.getDescription() + " Promotion price reduced!");
        offerEntity.setPrice(new BigDecimal(1_540_000));

        /* getByPrimaryKey() */
        System.out.println(" getByPrimaryKey() ");
        offerEntityOptional = repository.getByPrimaryKey(100L);
        offerEntityOptional.ifPresent(System.out::println);


        /* delete()*/
        System.out.println(" delete() ");
        offerEntityOptional.ifPresent(repository::delete);


        /* getAll() */
        System.out.println(" getAll() ");
        offers = repository.getAll();
        System.out.println(offers);

        session.close();
//        jdbcConnection.close();
    }

}
