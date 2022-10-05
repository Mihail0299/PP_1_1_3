package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private final static String url = "jdbc:mysql://localhost:3306/myfirstbase";
    private final static String username = "root";
    private final static String password = "Lalka000";
    private final static String dialect = "org.hibernate.dialect.MySQLDialect";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        SessionFactory nowsession;
        try {
            Properties properties = new Properties();
            properties.setProperty(Environment.URL, url);
            properties.setProperty(Environment.USER, username);
            properties.setProperty(Environment.PASS, password);
            properties.setProperty(Environment.DIALECT, dialect);
            Configuration configuration = new Configuration();
            configuration.setProperties(properties).addAnnotatedClass(User.class);
            nowsession = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return nowsession;
    }
}
