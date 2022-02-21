/* Задание
Написать консольное приложение (одно на выбор) из данного списка.
https://careers.epam.by/content/dam/epam/by/book_epam_by/JAVA_Methods_Programming_v2.march201
5.pdf на странице 126, не используя доступа к базе данных и DAO.


Транспорт. Определить иерархию подвижного состава железнодорожного
транспорта. Создать пассажирский поезд. Подсчитать общую численность
пассажиров и багажа. Провести сортировку вагонов поезда на основе уровня комфортности.
Найти в поезде вагоны, соответствующие заданному диапазону параметров числа пассажиров.
*/

package com.itvdn.jdbcHibernate.petrov.lesson002.homeWork.addTask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int getRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * maxValue) + minValue;
    }

    public static int getRandomNumber(int maxValue) {
        return getRandomNumber(0, maxValue);
    }

    public static void main(String[] args) {
        PassengerTrain train = new PassengerTrain();
        List<PassengerWagon> wagons = new ArrayList<>();
        for (int i = 0; i < getRandomNumber(18); i++) {
            int comfortLevel = getRandomNumber(PassengerWagon.MIN_COMFORT_LEVEL, PassengerWagon.MAX_COMFORT_LEVEL);
            PassengerWagon wagon = new PassengerWagon(comfortLevel);
            int numberOfPassengers = getRandomNumber(PassengerWagon.MAX_NUMBER_OF_PASSENGER_PLACES);
            int numberOfLuggage = getRandomNumber(numberOfPassengers * PassengerWagon.AVG_NUMBER_OF_LUGGAGE_BY_ONE_PASSENGER);
            wagon.setNumberOfPassengers(numberOfPassengers);
            wagon.setNumberOfLuggage(numberOfLuggage);
            wagons.add(wagon);
        }
        train.setWagons(wagons);
        System.out.println(train);
    }
}
