/* Задание 2
Используя дополнительное задания все вопросы записать в текстовом файле с новой строки каждый и
используя потоки ввода-вывода считать с файла все запросы и выполнить.*/

package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.task002;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "../JDBC-Hibernate/src/main/java/com/itvdn/jdbcHibernate/petrov/lesson001/homeWork/task002/queries.sql";
        List<String> lines = Reader.readLines(filePath);
        DBWorker dbWorker = new DBWorker();
        for (String line : lines) {
            System.out.println(line);
            dbWorker.executeQuery(line);
            System.out.println();
        }
    }
}
