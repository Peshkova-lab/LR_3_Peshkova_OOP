package com.company;

import java.util.ArrayList;

public class Main {

    public static class Station{
        int maxSpaceship = 5;
        float maxWeight = 3000f;
        static float currentWeight = 0f;
        ArrayList <Spaceship> spaceships = new ArrayList<Spaceship>();
        ArrayList <Spaceship>  spaceshipsDenied = new ArrayList<Spaceship>();
        public void addSpaceship(Spaceship spaceship){
            if (spaceships.size()<maxSpaceship) {
                currentWeight+=spaceship.getWeight();
                if(currentWeight<=maxWeight){
                    if(spaceship.getTeam().equalsIgnoreCase("turian")){
                        spaceships.add(spaceship);
                        for (Spaceship spaceship_i:spaceships) {
                            if (spaceship_i.getTeam().equalsIgnoreCase("earthling")
                                    || spaceship_i.getTeam().equalsIgnoreCase("walker"))
                            {   spaceships.remove(spaceship);
                                spaceshipsDenied.add(spaceship);
                                break;}
                        }
                    }
                    else if (spaceship.getTeam().equalsIgnoreCase("earthling")
                            || spaceship.getTeam().equalsIgnoreCase("walker")){
                        spaceships.add(spaceship);
                        for (Spaceship spaceship_i:spaceships) {
                            if (spaceship_i.getTeam().equalsIgnoreCase("turian"))
                            {   spaceships.remove(spaceship);
                                spaceshipsDenied.add(spaceship);
                                break;}
                        }
                    }

                }
                else {
                    currentWeight-=spaceship.getWeight();
                    spaceshipsDenied.add(spaceship);
                }
            }
            else spaceshipsDenied.add(spaceship);
        }
        public void delSpaceship(Spaceship spaceship){
            if (spaceships.contains(spaceship)){
                currentWeight-=spaceship.getWeight();
                spaceships.remove(spaceship);
            }
        }

        public void report(){
            System.out.println("Ships received at the station: \n" + spaceships + "\n");
            System.out.println("Ships denied access: \n" + spaceshipsDenied + "\n");
        }

        @Override
        public String toString() {
            return "Station{" +
                    "maxSpaceship=" + maxSpaceship +
                    "\n maxWeight=" + maxWeight +
                    "\n spaceships=" + spaceships +
                    '}';
        }
    }

    static public class Spaceship{
        String team;
        float weight = 10f;
        public Spaceship(String team, float weight){
            this.team = team;
            this.weight = weight;
        }
        public float getWeight() {
            return weight;
        }
        public String getTeam() {
            return team;
        }
        @Override
        public String toString() {
            return "Spaceship{" +
                    "team='" + team + '\'' +
                    ", weight=" + weight +
                    "} \n";
        }
    }

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
