package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.task005;

import java.sql.Date;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String address;
    private Date birthDay;

    public Employee(String firstName, String middleName, String lastName, String phone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Employee(String firstName, String middleName, String lastName, String phone, String address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Employee(String firstName, String middleName, String lastName, String phone, Date birthDay) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                (address == null ? "" : ", address='" + address + '\'') +
                (birthDay == null ? "" :  ", birthDay=" + birthDay) +
                '}';
    }
}
