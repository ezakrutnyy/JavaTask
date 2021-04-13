package jdbc.repository;

import com.google.common.collect.Lists;
import jdbc.dao.OfferDao;
import jdbc.entity.OfferEntity;
import jdbc.entity.ProductAccountingEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.MetaDataAccessException;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OfferJdbcTemplateDao implements OfferDao {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String LOGIN = "TM_ORACLE";

    private static final String PASSWORD = "TM_ORACLE_PASSWORD";

    private JdbcTemplate jdbcTemplate;

    public OfferJdbcTemplateDao() {
        DataSource dataSource = new DriverManagerDataSource(URL, LOGIN, PASSWORD);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(OfferEntity offer) {

    }

    @Override
    public void update(OfferEntity offer) {

    }

    @Override
    public void delete(OfferEntity offer) {

    }

    @Override
    public List<OfferEntity> getAll() {
        return null;
    }

    @Override
    public Optional<OfferEntity> getByPrimaryKey(Long pkey) {
        return Optional.empty();
    }

//    @Override
//    public List<ProductAccountingEntity> getAll() {
//        List<ProductAccountingEntity> entities = jdbcTemplate.query("Select * from ProductAccounting", new ProductAccountingMapper());
//        System.out.println(entities);
//        return entities;
//    }
//
//    @Override
//    public Optional<ProductAccountingEntity> getByPrimaryKey(Long pkey) {
//        return Optional.empty();
//    }
//
//    public void fillData() {
//
//        GetTableNames callTables = new GetTableNames();
//        try {
//            List<String> tables = (List<String>) JdbcUtils.extractDatabaseMetaData(jdbcTemplate.getDataSource(), callTables);
//
//            for (String table : tables) {
//                List<String> values = jdbcTemplate.query("SELECT * FROM " + table, (rs) -> {
//                    List<String> res = Lists.newArrayList();
//                    while (rs.next()) {
//
//                        StringBuilder strBuilder = new StringBuilder();
//                        strBuilder.append(table.toUpperCase()).append(":");
//
//                        // Количество колонок в результирующем запросе
//                        int columns = rs.getMetaData().getColumnCount();
//
//                        // Перебор строк с данными
//                        for (int i = 1; i <= columns; i++) {
//                            strBuilder.append(rs.getString(i)).append(";");
//                        }
//
//                        res.add(strBuilder.toString());
//                    }
//
//                    return res;
//                });
//
//                System.out.println(values);
//            }
//
//
//            // получаем все элементы из таблицы
//        } catch (MetaDataAccessException e) {
//            e.printStackTrace();
//        }
//
//    }
}

class GetTableNames implements DatabaseMetaDataCallback {

    @Override
    public Object processMetaData(DatabaseMetaData dbmd) throws SQLException, MetaDataAccessException {
        ResultSet rs = dbmd.getTables(null, dbmd.getUserName(), null, new String[]{"TABLE"});
        List<String> names = Lists.newArrayList();
        while (rs.next()) {
            names.add(rs.getString(3));
        }
        return names;
    }
}

class ProductAccountingMapper implements RowMapper {
    @Override
    public ProductAccountingEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductAccountingEntity prodAccounting = new ProductAccountingEntity();
        prodAccounting.setProductAccountingId(rs.getLong("PRODUCTACCOUNTINGID"));
        prodAccounting.setProductAccountingType(rs.getString("PRODUCTACCOUNTINGTYPE"));
        prodAccounting.setProductAccountingStatus(rs.getString("PRODUCTACCOUNTINGSTATUS"));
        return prodAccounting;
    }
}
