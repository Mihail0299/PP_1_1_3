package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users (\n" +
                "                     id SERIAL PRIMARY KEY,\n" +
                "                     name VARCHAR(80),\n" +
                "                     lastName VARCHAR(80),\n" +
                "                     age INT\n" +
                "                   )";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users (name, lastname, age) \n" +
                "VALUES (?, ?, ?)";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                Byte age = resultSet.getByte("age");
                user.add(new User(name, lastName, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void cleanUsersTable() {
        String query = "TRUNCATE TABLE users";
        try (Connection con = Util.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
