package jdbc.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTmConnection implements ConnectionTM {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";

    private static final String LOGIN = "TM_ORACLE";

    private static final String PASSWORD = "TM_ORACLE_PASSWORD";

    private static ConnectionTM factory;

    private JdbcTmConnection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Loaded Oracle Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static ConnectionTM getInstance() {
        if (factory == null) {
            synchronized (JdbcTmConnection.class) {
                if (factory == null) {
                    factory = new JdbcTmConnection();
                }
            }
        }
        return factory;
    }

    public Object connect() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
