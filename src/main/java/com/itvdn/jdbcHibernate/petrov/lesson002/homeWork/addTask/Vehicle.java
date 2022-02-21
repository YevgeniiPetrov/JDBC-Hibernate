package com.itvdn.jdbcHibernate.petrov.lesson002.homeWork.addTask;

abstract public class Vehicle implements Movable {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
