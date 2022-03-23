/* Задание 5
Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
1) Получите контактные данные сотрудников (номера телефонов, место жительства).
2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.*/

package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.task005;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();
        // 1) Получите контактные данные сотрудников (номера телефонов, место жительства).
        List<Employee> employees1 = dbWorker.getEmployees1();
        System.out.println(employees1);
        // 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
        List<Employee> employees2 = dbWorker.getEmployees2();
        System.out.println(employees2);
        // 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
        List<Employee> employees3 = dbWorker.getEmployees3();
        System.out.println(employees3);
    }
}
