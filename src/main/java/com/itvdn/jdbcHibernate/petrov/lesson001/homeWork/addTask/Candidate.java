package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.addTask;

public class Candidate {
    private int recruiterId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    public Candidate(int recruiterId, String firstName, String middleName, String lastName, String email, String phone) {
        this.recruiterId = recruiterId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "recruiterId=" + recruiterId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
