package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;


// speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly). Doesn't care about trucks.
public class Motorcycle extends Vehicle {
    private final static int MAX_SPEED_IS_RAINING = 95;
    private final static int MIN_SPEED_IS_RAINING = 50;
    private int motorcycleNumber;
    private String name;


    public Motorcycle(int motorcycleNumber) {
        this.name = createName(motorcycleNumber);
        this.distanceTraveled = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    private String createName(int motorcycleNumber) {
        this.name = "Motorcycle " + motorcycleNumber;
        return name;
    }

    public void prepareForLap(Race race) {
        if (race.getIsRaining()) {
            speed = (int) (Math.floor(Math.random() * (MAX_SPEED_IS_RAINING - MIN_SPEED_IS_RAINING)) + MIN_SPEED_IS_RAINING);
        }
    }

    public void moveForAnHour() {
        this.distanceTraveled += speed;

    }
}
