package com.company;
import java.util.ArrayList;

public class Station {
    int maxSpaceship = 5;
    float maxWeight = 3000f;
    static float currentWeight = 0f;
    ArrayList<Spaceship> spaceships = new ArrayList<Spaceship>();
    ArrayList <Spaceship>  spaceshipsDenied = new ArrayList<Spaceship>();
    public int addSpaceship(Spaceship spaceship){
        if (checkCountSpaceships(spaceship)) {
            currentWeight+=spaceship.getWeight();
            if(checkWeightSpaceships(spaceship)){
                if(isTurian(spaceship)){
                    spaceships.add(spaceship);
                    for (Spaceship spaceship_i:spaceships) {
                        if (isEarthling(spaceship) || isWalker(spaceship))
                        {   spaceships.remove(spaceship);
                            spaceshipsDenied.add(spaceship);
                            return -1;}
                    }
                    return 1;
                }
                else if (isEarthling(spaceship) || isWalker(spaceship)){
                    spaceships.add(spaceship);
                    for (Spaceship spaceship_i:spaceships) {
                        if (isTurian(spaceship))
                        {   spaceships.remove(spaceship);
                            spaceshipsDenied.add(spaceship);
                            return -1;}
                    }
                    return 1;
                }

            }
            else {
                currentWeight-=spaceship.getWeight();
                spaceshipsDenied.add(spaceship);
                return -1;
            }
        }
        else spaceshipsDenied.add(spaceship);
        return -1;
    }
    public boolean checkCountSpaceships(Spaceship spaceship) {
        if (spaceships.size()<maxSpaceship) return true;
        return false;
    }
    public boolean checkWeightSpaceships (Spaceship spaceship) {
        if (currentWeight <= maxWeight) return true;
        return false;
    }
    public boolean isTurian (Spaceship spaceship) {
        if (spaceship.getTeam().equalsIgnoreCase("turian")) return true;
        return false;
    }
    public boolean isEarthling (Spaceship spaceship) {
        if (spaceship.getTeam().equalsIgnoreCase("earthling")) return true;
        return false;
    }
    public boolean isWalker (Spaceship spaceship) {
        if (spaceship.getTeam().equalsIgnoreCase("walker")) return true;
        return false;
    }
    public void report(){
        System.out.println("Ships received at the station: \n" + spaceships + "\n");
        System.out.println("Ships denied access: \n" + spaceshipsDenied + "\n");
    }

    public void delSpaceship(Spaceship spaceship){
        if (spaceships.contains(spaceship)){
            currentWeight-=spaceship.getWeight();
            spaceships.remove(spaceship);
        }
    }
    public boolean stationIsEmpty() {
        if (spaceships.size()!=0) return false;
        return true;
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