/* Задание
Создать новую базу данных с помощью MySQLWorkbench. Создать обычный java-проект и подключить к
нему библиотеки JPA и Hibernate. Создать файл с настройками persistence.xml в папке META-INF. И
создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей
таблице. И с помощью jpa сделать crud в классе AnimalHelper.*/

package com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask;

import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.AnimalDAO;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.DAOFactory;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.impl.DAOFactoryImpl;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.entity.MyAnimal;

public class Main {
    public static void main(String[] args) {
        MyAnimal myAnimal = MyAnimal
                .builder()
                .age(10)
                .name("Murzik")
                .tail(true)
                .build();
        DAOFactory DAOFactory = new DAOFactoryImpl();
        AnimalDAO animalDAO = DAOFactory.getAnimalDAO();
        animalDAO.add(myAnimal);
        myAnimal.setAge(20);
        animalDAO.update(myAnimal);
    }
}
