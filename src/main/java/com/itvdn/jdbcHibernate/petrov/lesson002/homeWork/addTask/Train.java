package com.itvdn.jdbcHibernate.petrov.lesson002.homeWork.addTask;

import java.util.ArrayList;
import java.util.List;

abstract public class Train extends Vehicle {
    private List<? extends Wagon> wagons;

    public Train() {
        wagons = new ArrayList<>();
    }

    public List<? extends Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<? extends Wagon> wagons) {
        this.wagons = wagons;
    }

    @Override
    public String toString() {
        return "Train{" +
                "wagons=" + wagons +
                '}';
    }
}
