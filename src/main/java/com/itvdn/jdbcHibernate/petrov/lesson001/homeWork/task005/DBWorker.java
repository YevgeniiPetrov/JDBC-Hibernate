package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.task005;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/my_joins_db";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private final String FIRST_NAME = "first_name";
    private final String MIDDLE_NAME = "middle_name";
    private final String LAST_NAME = "last_name";
    private final String PHONE = "phone";
    private final String ADDRESS = "address";
    private final String BIRTHDAY = "date_of_birth";

    public DBWorker() {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 1) Получите контактные данные сотрудников (номера телефонов, место жительства).
    public List<Employee> getEmployees1() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("" +
                    "select " +
                    "   e.last_name as " + LAST_NAME + ", " +
                    "   e.first_name as " + FIRST_NAME + ", " +
                    "   e.middle_name as " + MIDDLE_NAME + ", " +
                    "   e.phone as " + PHONE + ", " +
                    "   epd.address as " + ADDRESS + " "+
                    "from " +
                    "   employee e " +
                    "   join employee_personal_data epd " +
                    "where " +
                    "   epd.employee_id = e.id;");
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString(FIRST_NAME),
                        resultSet.getString(MIDDLE_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(PHONE),
                        resultSet.getString(ADDRESS)
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
    public List<Employee> getEmployees2() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("" +
                    "select " +
                    "   e.last_name as " + LAST_NAME + ", " +
                    "   e.first_name as " + FIRST_NAME + ", " +
                    "   e.middle_name as " + MIDDLE_NAME + ", " +
                    "   e.phone as " + PHONE + ", " +
                    "   epd.date_of_birth as " + BIRTHDAY + " "+
                    "from " +
                    "   employee e " +
                    "   join employee_personal_data epd " +
                    "where " +
                    "   epd.employee_id = e.id" +
                    "   and epd.married = false;");
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString(FIRST_NAME),
                        resultSet.getString(MIDDLE_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(PHONE),
                        resultSet.getDate(BIRTHDAY)
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
    public List<Employee> getEmployees3() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("" +
                    "select " +
                    "   e.last_name as " + LAST_NAME + ", " +
                    "   e.first_name as " + FIRST_NAME + ", " +
                    "   e.middle_name as " + MIDDLE_NAME + ", " +
                    "   e.phone as " + PHONE + ", " +
                    "   epd.date_of_birth as " + BIRTHDAY + " "+
                    "from " +
                    "   employee e " +
                    "   join employee_personal_data epd " +
                    "   join post p " +
                    "where " +
                    "   epd.employee_id = e.id " +
                    "   and p.id = e.post_id " +
                    "   and p.title = 'Менеджер';");
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getString(FIRST_NAME),
                        resultSet.getString(MIDDLE_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(PHONE),
                        resultSet.getDate(BIRTHDAY)
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
