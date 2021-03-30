package com.company;

public class Main {
    public static void main(String[] args) {

        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 100f);
        Spaceship spaceship1 = new Spaceship("Walker", 1000f);
        Spaceship spaceship3 = new Spaceship("Earthling", 1000f);
        Spaceship spaceship4 = new Spaceship("People4", 1000f);
        Spaceship spaceship5 = new Spaceship("People5", 1000f);

        station.addSpaceship(spaceship);
        station.addSpaceship(spaceship1);
        station.addSpaceship(spaceship3);
        station.addSpaceship(spaceship4);
        station.addSpaceship(spaceship5);

        System.out.println(station);

        station.report();
    }
}
