package jdbc.repository;

import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OfferHibernateDao implements OfferDao {

    private final Session session;

    public OfferHibernateDao(Session session) {
        this.session = session;
    }

    @Override
    public void insert(OfferEntity offer) {
        try {
            session.beginTransaction();
            session.save(offer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(OfferEntity offer) {
        try {
            session.beginTransaction();
            session.update(offer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(OfferEntity offer) {
        try {
            session.beginTransaction();
            session.delete(offer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<OfferEntity> getAll() {
        List<OfferEntity> offers = null;
        try {
            session.beginTransaction();
            offers = session.createQuery("from OfferEntity", OfferEntity.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (Objects.nonNull(session.getTransaction())) {
                session.getTransaction().rollback();
            }
        }
        return offers;
    }

    @Override
    public Optional<OfferEntity> getByPrimaryKey(Long pkey) {
        OfferEntity offer = null;
        try {
            session.beginTransaction();
            offer = session.get(OfferEntity.class, pkey);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (Objects.nonNull(session.getTransaction())) {
                session.getTransaction().rollback();
            }
        }
        return Objects.isNull(offer) ? Optional.empty() : Optional.of(offer);
    }


}
