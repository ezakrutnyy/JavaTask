package jdbc.repository;

import jdbc.dao.ProductAccountingDao;
import jdbc.entity.ProductAccountingEntity;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ProductAccountingHibernateDao implements ProductAccountingDao {

    private final Session session;

    public ProductAccountingHibernateDao(Session session) {
        this.session = session;
    }

    @Override
    public void insert(final ProductAccountingEntity productAccountingEntity) {
        session.beginTransaction();
        session.save(productAccountingEntity);
        session.getTransaction().commit();
    }

    @Override
    public void update(ProductAccountingEntity productAccountingEntity) {
        session.beginTransaction();
        session.update(productAccountingEntity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(ProductAccountingEntity productAccountingEntity) {
        session.beginTransaction();
        session.delete(productAccountingEntity);
        session.getTransaction().commit();
    }

    @Override
    public List<ProductAccountingEntity> getAll() {
        session.beginTransaction();
        List<ProductAccountingEntity> res =
                session.createQuery("from ProductAccountingEntity", ProductAccountingEntity.class).list();
        session.getTransaction().commit();
        return res;
    }

    @Override
    public Optional<ProductAccountingEntity> getByPrimaryKey(Long pkey) {
        session.beginTransaction();
        ProductAccountingEntity productAccountingEntity = session.get(ProductAccountingEntity.class, pkey);
        session.getTransaction().commit();
        return Optional.ofNullable(productAccountingEntity);
    }


}
