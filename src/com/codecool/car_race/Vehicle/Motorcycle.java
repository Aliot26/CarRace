package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;


// speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly). Doesn't care about trucks.
public class Motorcycle extends Vehicle {
    private final static int MAX_SPEED_IS_RAINING = 95;
    private final static int MIN_SPEED_IS_RAINING = 50;

    public Motorcycle(int motorcycleNumber) {
        setName(motorcycleNumber);
    }

    private void setName(int motorcycleNumber) {
        this.name = "Motorcycle " + motorcycleNumber;
    }

    public void prepareForLap(Race race) {
        if (race.getIsRaining()) {
            speed = generateSpeed(MAX_SPEED_IS_RAINING,MIN_SPEED_IS_RAINING);
        }else {
            speed = DEFAULT_SPEED;
        }
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getDistanceTraveled() + " km";
    }
}
