package jdbc;

import jdbc.connections.JdbcTmConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAccountingCreator {

    public static void main(String[] args)  {

        final Connection jdbcConnection = (Connection) JdbcTmConnection.getInstance().connect();

        List<String> queries;
        try (BufferedReader buf = new BufferedReader(new FileReader(
                new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\src\\jdbc\\scripts\\createTable.sql")))) {
            queries = buf.lines().map(str -> str.replace(";", " ")).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("BufferedReader Exception");
            throw new RuntimeException(ex);
        }

        Statement statement = null;
        try {
            statement = jdbcConnection.createStatement();
            for (String query : queries) {
                statement.executeUpdate(query);
            }
        } catch (SQLException slqEx) {
            System.out.println("Error create Statement: " + slqEx.getMessage());
            System.out.println("SqlState: " + slqEx.getSQLState());
            throw new RuntimeException(slqEx);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                jdbcConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}