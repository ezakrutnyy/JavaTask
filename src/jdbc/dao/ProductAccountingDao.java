package jdbc.dao;

import jdbc.entity.ProductAccountingEntity;

import java.util.List;
import java.util.Optional;

public interface ProductAccountingDao {

    void insert(final ProductAccountingEntity productAccountingEntity);

    void update(final ProductAccountingEntity productAccountingEntity);

    void delete(final ProductAccountingEntity productAccountingEntity);

    List<ProductAccountingEntity> getAll();

    Optional<ProductAccountingEntity> getByPrimaryKey(Long pkey);

}
