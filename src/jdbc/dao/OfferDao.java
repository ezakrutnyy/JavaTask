package jdbc.dao;

import jdbc.entity.OfferEntity;

import java.util.List;
import java.util.Optional;

public interface OfferDao {

    void insert(final OfferEntity offer);

    void update(final OfferEntity offer);

    void delete(final OfferEntity offer);

    List<OfferEntity> getAll();

    Optional<OfferEntity> getByPrimaryKey(Long pkey);

}
