/* Задание
Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
Заполнить ее данными с помощью запросов MySQL в IntelijIdea. Используя JDBC написать пример выполнения всех запросов.*/

package com.itvdn.jdbcHibernate.petrov.lesson001.homeWork.addTask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate(1, "Максим", "Олегович", "Петров", "petrov@gmail.com", "+380634444444"));
        candidates.add(new Candidate(2, "Андрей", "Алексеевич", "Иванов", "ivanov@gmail.com", "+380965555555"));
        candidates.add(new Candidate(1, "Олег", "Александрович", "Сидоров", "sidorov@ukr.net", "+380507777777"));
        candidates.add(new Candidate(1, "Игорь", "Александрович", "Кузнецов", "kuznetsov@ukr.net", "+380509999999"));
        candidates.add(new Candidate(3, "Виктор", "Иванович", "Скворцов", "skvortsov@ukr.net", "+380938888888"));
        int insertResult = dbWorker.insertCandidates(candidates);
        System.out.println(insertResult);
        System.out.println(dbWorker.getAllCandidates());
    }
}
