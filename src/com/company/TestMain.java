package com.company;
import org.junit.Assert;
import org.junit.Test;

public class TestMain {
    @Test
    public void testAddSpaceshipSuccess() throws Exception{
        Station station = new Station();
        Spaceship spaceship = new Spaceship("earthling", 1000f);

        Assert.assertEquals(1, station.addSpaceship(spaceship));

        Spaceship spaceship1 = new Spaceship("earthling", 10000f);
        Assert.assertEquals(-1, station.addSpaceship(spaceship1));
    }
}
