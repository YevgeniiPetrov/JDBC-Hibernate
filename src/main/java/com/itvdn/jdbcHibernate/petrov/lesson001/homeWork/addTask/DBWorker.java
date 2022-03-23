package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.addTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBWorker {
    private final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/human_resource";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private final String RECRUITER_ID = "recruiter_id";
    private final String FIRST_NAME = "first_name";
    private final String MIDDLE_NAME = "middle_name";
    private final String LAST_NAME = "last_name";
    private final String EMAIL = "email";
    private final String PHONE = "phone";

    public DBWorker() {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int insertCandidates(List<Candidate> candidates) {
        int[] result = {0};
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            for (Candidate cd : candidates) {
                statement.addBatch("insert into candidate" +
                        "   (" + RECRUITER_ID + "," + FIRST_NAME + "," + MIDDLE_NAME + "," + LAST_NAME + "," + EMAIL + "," + PHONE + ") " +
                        "values" +
                        "   (" + cd.getRecruiterId() + ",'" + cd.getFirstName() + "','" + cd.getMiddleName() + "','" + cd.getLastName() + "','" + cd.getEmail() + "','" + cd.getPhone() + "')");
            }
            result = statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Arrays.stream(result).sum();
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from candidate;");
            while (resultSet.next()) {
                Candidate candidate = new Candidate(
                        resultSet.getInt(RECRUITER_ID),
                        resultSet.getString(FIRST_NAME),
                        resultSet.getString(MIDDLE_NAME),
                        resultSet.getString(LAST_NAME),
                        resultSet.getString(EMAIL),
                        resultSet.getString(PHONE)
                );
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}
