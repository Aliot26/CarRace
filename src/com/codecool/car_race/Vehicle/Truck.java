package com.codecool.car_race.Vehicle;


import java.util.HashSet;
import java.util.Set;

// speed: 100km/h. 5% chance of breaking down for 2 turns.
public class Truck extends Vehicle {
    private final static int BREAKDOWN_CHANCE_PERCENT = 5;
    private final static int BREAKDOWN_DURATION_HR = 2;
    private int name;
    private int breakdownTurnsLeft;
    private int distanceTraveled;

    private Set<Integer> numbersExist = new HashSet<>();

    public Truck() {
        this.name = generateName();
    }

    public int getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }


    private int generateName() {
        boolean nameExists = true;
        while (nameExists) {
            name = (int) (Math.floor(Math.random() * (1000 - 1)) + 1);
            if (!numbersExist.contains(name)) {
                nameExists = false;
                numbersExist.add(name);
            }
        }
        return name;
    }


    private void randomBreakdown() {
        if ((int) (Math.floor(Math.random() * (100))) < BREAKDOWN_CHANCE_PERCENT) {
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
