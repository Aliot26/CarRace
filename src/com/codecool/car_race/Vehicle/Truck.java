package com.codecool.car_race.Vehicle;


import java.util.HashSet;
import java.util.Set;

// speed: 100km/h. 5% chance of breaking down for 2 turns.
public class Truck extends Vehicle {
    private final static int BREAKDOWN_CHANCE_PERCENT = 5;
    private final static int BREAKDOWN_DURATION_HR = 2;
    private int breakdownTurnsLeft;
    private Set<String> numbersExist = new HashSet<>();

    public Truck() {
        generateName();
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    private void generateName() {
        do {
            name = String.valueOf((int) (Math.floor(Math.random() * (1000 - 1)) + 1));// because this may be name of the track
            numbersExist.add(name);
        } while (!numbersExist.contains(name));
    }

    private void randomBreakdown() {
        if ((int) (Math.floor(Math.random() * (100))) < BREAKDOWN_CHANCE_PERCENT) {// because 100 %
            breakdownTurnsLeft += BREAKDOWN_DURATION_HR;
        }
    }

    public void moveForAnHour() {
        if (breakdownTurnsLeft == 0) {
            distanceTraveled += speed;
            randomBreakdown();
        } else {
            breakdownTurnsLeft--;
        }
    }
}
