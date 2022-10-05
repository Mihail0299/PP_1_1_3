package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String url = "jdbc:mysql://localhost:3306/myfirstbase";
    private final static String username = "root";
    private final static String password = "Lalka000";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
