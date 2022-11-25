package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String URL = properties.getProperty("host");
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(URL, name, password);
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;
        try {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/firstbase");
            properties.setProperty("hibernate.connection.username", "postgres");
            properties.setProperty("hibernate.connection.password", "Lalka000");
            properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.setProperty("hibernate.show_sql", "true");
            sessionFactory = new Configuration().setProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return sessionFactory;
    }
}
