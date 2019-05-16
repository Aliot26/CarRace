package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car extends Vehicle {
    private final static int MAX_SPEED = 110;
    private final static int MIN_SPEED = 80;
    private final static int SPEED_WHEN_BROKEN_TRUCK = 75;
    private List<String> names = new ArrayList<>(Arrays.asList("Crest", "Temperament",
            "Crusader", "Phantom", "Paragon", "Desire", "Adventure", "Blade",
            "Surge", "Stardust","Buffalo", "Roamer", "Utopia", "Pulse",
            "Centaur", "Pyre", "Treasure","Apex", "Tempest",  "Aurora"));
    private int speed;
    private String name;

    public Car() {
        this.speed = generateSpeed();
        this.name = generateCarName();
        this.distanceTraveled = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }


    private String generateCarName() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(names.get(r.nextInt(names.size())));
        sb.append("-");
        sb.append(names.get(r.nextInt(names.size())));
        return sb.toString();
    }


    private int generateSpeed() {
        return (int) (Math.floor(Math.random() * (MAX_SPEED - MIN_SPEED)) + MIN_SPEED);
    }


    public void prepareForLap(Race race) {
        if (race.isThereBrokenTruck()) {
            speed = SPEED_WHEN_BROKEN_TRUCK;
        }
    }


    public void moveForAnHour() {
            distanceTraveled += speed;
    }
}
