package com.itvdn.jdbcHibernate.petrov.lesson002.homeWork.addTask;

public class PassengerWagon extends Wagon {
    public static final int MAX_NUMBER_OF_PASSENGER_PLACES = 54;
    public static final int AVG_NUMBER_OF_LUGGAGE_BY_ONE_PASSENGER = 2;
    public static final int MIN_COMFORT_LEVEL = 1;
    public static final int MAX_COMFORT_LEVEL = 5;

    private int comfortLevel;
    private int numberOfPassengers;
    private int numberOfLuggage;

    public PassengerWagon(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfLuggage() {
        return numberOfLuggage;
    }

    public void setNumberOfLuggage(int numberOfLuggage) {
        this.numberOfLuggage = numberOfLuggage;
    }

    @Override
    public void move() {
        System.out.println("Choo choo choo");
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "comfortLevel=" + comfortLevel +
                ", numberOfPassengers=" + numberOfPassengers +
                ", numberOfLuggage=" + numberOfLuggage +
                '}';
    }
}
