package thread.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {

        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection(URL);
            } catch (SQLException e) {
                throw new RuntimeException("Connection error!");
            }
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

}


