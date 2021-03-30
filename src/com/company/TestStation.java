package com.company;
import org.junit.Assert;
import org.junit.Test;

public class TestStation {
    @Test
    public void testAddSpaceshipSuccess() throws Exception{
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 1000f);
        Assert.assertEquals("Spaceship was added incorrectly",1, station.addSpaceship(spaceship));

        Spaceship spaceship1 = new Spaceship("earthling", 10000f);
        Assert.assertEquals("Spaceship was not added correctly",-1, station.addSpaceship(spaceship1));
    }
    @Test
    public void testCheckMaxCountSpaceships() throws Exception{
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 200f);
        station.addSpaceship(spaceship);

        Assert.assertTrue("Count of spaceships is incorrect", station.checkMaxCountSpaceships());

        station.addSpaceship(spaceship);
        Assert.assertFalse("Count of spaceships is incorrect", station.checkMaxCountSpaceships());
    }
    @Test
    public void testCheckCurrentWeightSpaceships() throws Exception {
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 200f);

        Assert.assertTrue("Current weight is incorrect", station.checkCurrentWeightSpaceships(spaceship));

        Spaceship spaceship1 = new Spaceship("earthling", 20000f);
        Assert.assertFalse("Current weight is incorrect", station.checkCurrentWeightSpaceships(spaceship1));
    }
    @Test
    public void testIsTeam() {
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 200f);
        Spaceship spaceship1 = new Spaceship("Walker", 100f);
        Spaceship spaceship2 = new Spaceship("turian", 10f);

        Assert.assertTrue("It is earthling, test incorrect", station.isEarthling(spaceship));
        Assert.assertTrue("It is walker, test incorrect", station.isWalker(spaceship1));
        Assert.assertTrue("It is turian, test incorrect", station.isTurian(spaceship2));

        Assert.assertFalse("It is not turian", station.isTurian(spaceship));
    }
    @Test
    public void testDeleteSpaceship() {
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 1000f);
        station.addSpaceship(spaceship);

        Assert.assertTrue("Delete spaceship did not happen", station.delSpaceship(spaceship));
        Assert.assertFalse("Delete spaceship happen, but it does not exist!", station.delSpaceship(spaceship));
    }
    @Test
    public void testStationIsEmpty(){
        Station station = new Station();

        Assert.assertTrue("Station is empty!", station.stationIsEmpty());

        Spaceship spaceship = new Spaceship("earthling", 1000f);
        station.addSpaceship(spaceship);

        Assert.assertFalse("Station is not empty!", station.stationIsEmpty());
    }

    @Test
    public void testReport(){
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 200f);
        Spaceship spaceship1 = new Spaceship("turian", 20000f);
        station.addSpaceship(spaceship);
        station.addSpaceship(spaceship1);

        Assert.assertEquals("Report incorrect", 0, station.report());
    }







}
