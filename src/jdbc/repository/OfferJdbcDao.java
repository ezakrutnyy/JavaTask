package jdbc.repository;

import com.google.common.collect.Lists;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;

import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OfferJdbcDao implements OfferDao {

    private final Connection connection;

    public OfferJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(OfferEntity offer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into Offer (id, category, title, create_date, price, description, user_id) " +
                    "values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, offer.getId());
            preparedStatement.setString(2, offer.getCategory());
            preparedStatement.setString(3, offer.getTitle());
            preparedStatement.setDate(4, new Date(offer.getCreateDate().getTime()));
            preparedStatement.setBigDecimal(5, offer.getPrice());
            preparedStatement.setString(6, offer.getDescription());
            preparedStatement.setLong(7, offer.getUserId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(OfferEntity offer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update Offer set  category = ?, title = ?, create_date = ?, " +
                    "price = ?, description = ?, user_id = ? where id = ?");
            preparedStatement.setString(1, offer.getCategory());
            preparedStatement.setString(2, offer.getTitle());
            preparedStatement.setDate(3, new Date(offer.getCreateDate().getTime()));
            preparedStatement.setBigDecimal(4, offer.getPrice());
            preparedStatement.setString(5, offer.getDescription());
            preparedStatement.setLong(6, offer.getUserId());
            preparedStatement.setLong(7, offer.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(OfferEntity offer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from Offer where id = ?");
            preparedStatement.setLong(1, offer.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<OfferEntity> getAll() {
        List<OfferEntity> offers = Lists.newArrayList();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from Offer");
            while (resultSet.next()) {
                OfferEntity offer = new OfferEntity();
                offer.setId(resultSet.getLong("id"));
                offer.setCategory(resultSet.getString("category"));
                offer.setTitle(resultSet.getString("title"));
                offer.setCreateDate(resultSet.getDate("create_date"));
                offer.setDescription(resultSet.getString("description"));
                offer.setPrice(resultSet.getBigDecimal("price"));
                offer.setUserId(resultSet.getLong("user_id"));
                offers.add(offer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return offers;
    }

    public Optional<OfferEntity> getByPrimaryKey(Long pkey) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        OfferEntity offer = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Offer where id = ?");
            preparedStatement.setLong(1, pkey);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                offer = new OfferEntity();
                offer.setId(pkey);
                offer.setCategory(resultSet.getString("category"));
                offer.setTitle(resultSet.getString("title"));
                offer.setCreateDate(resultSet.getDate("create_date"));
                offer.setDescription(resultSet.getString("description"));
                offer.setPrice(resultSet.getBigDecimal("price"));
                offer.setUserId(resultSet.getLong("user_id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return Objects.isNull(offer) ? Optional.empty() : Optional.of(offer);

    }
//    @Override
//    public void insert(ProductAccountingEntity productAccountingEntity) {
//        final String query = "INSERT INTO PRODUCTACCOUNTING " +
//                "(productAccountingId, productAccountingType, productAccountingStatus, amount, currency, createDate) " +
//                "VALUES (PRODUCTACCOUNTING_SEQ.nextVal,?,?,?,?,?)";
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, productAccountingEntity.getProductAccountingType());
//            preparedStatement.setString(2, productAccountingEntity.getProductAccountingStatus());
//            preparedStatement.setBigDecimal(3, productAccountingEntity.getAmount());
//            preparedStatement.setString(4, productAccountingEntity.getCurrency());
//            preparedStatement.setDate(5, new Date(productAccountingEntity.getCreateDate().getTime()));
//            preparedStatement.executeUpdate();
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException sqlEx) {
//                    sqlEx.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void delete(ProductAccountingEntity productAccountingEntity) {
//        final String query = "DELETE FROM PRODUCTACCOUNTING WHERE productAccountingId = ?";
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setLong(1, productAccountingEntity.getProductAccountingId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException sqlEx) {
//                    sqlEx.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void update(ProductAccountingEntity productAccountingEntity) {
//        PreparedStatement preparedStatement = null;
//        String query = "UPDATE PRODUCTACCOUNTING  " +
//                "SET productAccountingType = ?, productAccountingStatus = ?, amount = ?, currency = ?, createDate = ?" +
//                "WHERE productAccountingId = ?";
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, productAccountingEntity.getProductAccountingType());
//            preparedStatement.setString(2, productAccountingEntity.getProductAccountingStatus());
//            preparedStatement.setBigDecimal(3, productAccountingEntity.getAmount());
//            preparedStatement.setString(4, productAccountingEntity.getCurrency());
//            preparedStatement.setDate(5, new Date(productAccountingEntity.getCreateDate().getTime()));
//            preparedStatement.setLong(6, productAccountingEntity.getProductAccountingId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException sqlEx) {
//                    sqlEx.printStackTrace();
//                }
//            }
//        }
//    }


//    @Override
//    public List<ProductAccountingEntity> getAll() {
//        final List<ProductAccountingEntity> result = Lists.newArrayList();
//        final String query = "SELECT productAccountingId, productAccountingType, productAccountingStatus, amount, currency, createDate" +
//                " from PRODUCTACCOUNTING";
//
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                ProductAccountingEntity productAccountingEntity = new ProductAccountingEntity();
//                productAccountingEntity.setProductAccountingId(resultSet.getLong(1));
//                productAccountingEntity.setProductAccountingType(resultSet.getString(2));
//                productAccountingEntity.setProductAccountingStatus(resultSet.getString(3));
//                productAccountingEntity.setAmount(resultSet.getBigDecimal(4));
//                productAccountingEntity.setCurrency(resultSet.getString(5));
//                productAccountingEntity.setCreateDate(resultSet.getDate(6));
//                result.add(productAccountingEntity);
//            }
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException sqlEx) {
//                    sqlEx.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException sqlEx) {
//                    sqlEx.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public Optional<ProductAccountingEntity> getByPrimaryKey(Long pkey) {
//        final String query = "SELECT * from PRODUCTACCOUNTING where productAccountingId = ?";
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setLong(1, pkey);
//            ResultSet result = preparedStatement.executeQuery();
//            while (result.next()) {
//                ProductAccountingEntity prodAccounting = new ProductAccountingEntity();
//                prodAccounting.setProductAccountingType(result.getString("productAccountingType"));
//                prodAccounting.setProductAccountingStatus(result.getString("productAccountingStatus"));
//                prodAccounting.setAmount(result.getBigDecimal("amount"));
//                prodAccounting.setCurrency(result.getString("currency"));
//                prodAccounting.setCreateDate(result.getDate("createDate"));
//                prodAccounting.setProductAccountingId(pkey);
//                return Optional.of(prodAccounting);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        return Optional.empty();
//    }
}
