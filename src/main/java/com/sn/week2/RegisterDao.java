package com.sn.week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {

    // JDBC credentials (your limited user)
    private String jdbcURL = "jdbc:mysql://localhost:3306/cpan368";
    private String jdbcUsername = "cpan368_stevennguyen";
    private String jdbcPassword = "class123";

    // Static block to load the MySQL driver once
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Insert a new user into 'users' table
    public boolean insertUser(RegistrationClass user) {
        String INSERT_SQL = "INSERT INTO users (username, password, mobile, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMblnumber());
            preparedStatement.setString(4, user.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // <-- add this
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all users from 'users' table
    public List<RegistrationClass> getAllUsers() {
        List<RegistrationClass> users = new ArrayList<>();
        String SELECT_SQL = "SELECT id, username, password, mobile, email FROM users";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RegistrationClass user = new RegistrationClass();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMblnumber(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}