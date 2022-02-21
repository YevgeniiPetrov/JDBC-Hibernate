package com.itvdn.jdbcHibernate.petrov.lesson002.homeWork.addTask;

public class PassengerTrain extends Train {
    public int getNumberOfPassengers() {
        return 0;
    }

    public int getNumberOfLuggage() {
        return 0;
    }

    @Override
    public void move() {
        System.out.println("Choo choo choo");
    }
}
