package jdbc.tsql;

import jdbc.connections.JdbcTmConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallablePrepayment {

    public static void main(String[] args) {

        final Connection connection = (Connection) JdbcTmConnection.getInstance().connect();

        CallableStatement callableStatement = null;

        try {
            callableStatement = connection.prepareCall("CALL tm.prod_cnt(?)");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println("Количесво записей в таблице:" + callableStatement.getInt(1));
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
            try {
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }

        }


    }
}
