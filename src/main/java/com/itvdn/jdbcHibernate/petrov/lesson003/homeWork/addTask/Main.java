/* Задание
Создать новую базу данных с помощью MySQLWorkbench. Создать Maven-проект и настроить его
правильно. Создать файл с настройками hibernate.cfg.xml. И создать класс Animal(int age, String name,
boolean tail) с методами get и set, как сущность к нашей таблице. И с помощью hibernate создать новую
таблицу с начальным значением.*/

package com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask;

import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.dao.AnimalDAO;
import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.dao.DAOFactory;
import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.dao.impl.DAOFactoryImpl;
import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.entity.Animal;

public class Main {
    public static void main(String[] args) {
        Animal animal = Animal
                .builder()
                .age(10)
                .name("Murzik")
                .tail(true)
                .build();
        DAOFactory DAOFactory = new DAOFactoryImpl();
        AnimalDAO animalDAO = DAOFactory.getAnimalDAO();
        animalDAO.add(animal);
    }
}
