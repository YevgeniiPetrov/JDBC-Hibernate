package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.task002;

import java.sql.*;

public class DBWorker {
    private final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/human_resource";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public DBWorker() {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData setMetaData = resultSet.getMetaData();
            int columnCount = setMetaData.getColumnCount();
            while (resultSet.next()) {
                for(int i = 1; i < columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
