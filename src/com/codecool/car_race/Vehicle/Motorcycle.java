package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.Vehicle.Vehicle;


// speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly). Doesn't care about trucks.
public class Motorcycle extends Vehicle {
    private int motorcycleNumber = 1;
    private String name;
    private int distanceTraveled = 0;
    private int speed = 100;


    public Motorcycle() {
        this.name = createName();
        this.distanceTraveled = 0;
    }

    private String createName() {
        name = "Motorcycle " + motorcycleNumber;
        motorcycleNumber += 1;
        return name;
    }

    public void prepareForLap(Race race) {
        if (race.isRaining()) {
            speed = (int) (Math.floor(Math.random() * (95 - 50)) + 50);
        }
    }

    public void moveForAnHour() {
        distanceTraveled += speed;

    }
}
