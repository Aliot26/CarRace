package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;

public abstract class Vehicle {
    private String name;
    private int distanceTraveled;

    public void prepareForLap(Race race){
        //TODO setup the actual speed used for the current lap
    }
    public void moveForAnHour(){
        //TODO The vehicle travels for an hour.
        // It increases the distance traveled.
        // Call this from the Race::simulateRace() only!

    }
}

