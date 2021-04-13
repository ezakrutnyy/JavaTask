package jdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTmConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/bootsuite";

    private static final String LOGIN = "zak";

    private static final String PASSWORD = "zak";

    private static JdbcTmConnection factory;

    private JdbcTmConnection() {
    }

    public static JdbcTmConnection getInstance() {
        if (factory == null) {
            synchronized (JdbcTmConnection.class) {
                if (factory == null) {
                    factory = new JdbcTmConnection();
                }
            }
        }
        return factory;
    }

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
