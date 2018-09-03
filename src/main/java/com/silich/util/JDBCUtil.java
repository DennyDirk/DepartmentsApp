package com.silich.util;

import java.sql.*;

public class JDBCUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/departments?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Statement getStatement() {
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT*FROM departments.employees";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String fname = resultSet.getString("first_name");
                String lname = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                Date date = resultSet.getDate("created_on");

                System.out.println(id + " " + email + " " + fname + " " + lname
                        + " " + age + " " + date);

            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
