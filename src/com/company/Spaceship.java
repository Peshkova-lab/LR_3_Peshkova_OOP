package com.company;

public class Spaceship{
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
