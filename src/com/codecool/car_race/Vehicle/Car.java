package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Car extends Vehicle {
    List<String> names = new ArrayList<>(Arrays.asList("Crest", "Temperament",
            "Crusader", "Phantom", "Paragon", "Desire", "Adventure", "Blade",
            "Surge", "Stardust","Buffalo", "Roamer", "Utopia", "Pulse",
            "Centaur", "Pyre", "Treasure","Apex", "Tempest",  "Aurora"));
    private int normalSpeed;
    private String name;
    private int distanceTraveled;

    Car() {
        normalSpeed = generateSpeed();
        name = generateCarName();
        distanceTraveled = 0;
    }

    private String generateCarName() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(names.get(r.nextInt(20)));
        sb.append("-");
        sb.append(names.get(r.nextInt(20)));
        return sb.toString();
    }


    private int generateSpeed() {
        return (int) (Math.floor(Math.random() * (111 - 80)) + 80);
    }


    public void prepareForLap(Race race) {
        if (race.isThereBrokenTruck()) {
            normalSpeed = 75;
        } else {
            normalSpeed = normalSpeed;
        }
    }


    public void moveForAnHour() {
            distanceTraveled += normalSpeed;
    }
}
