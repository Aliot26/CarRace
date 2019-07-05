package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;

public abstract class Vehicle {

    int distanceTraveled;
    int speed;
    static final int DEFAULT_SPEED = 100;
    String name;

    public String getName() {
        return name;
    }

    public void prepareForLap(Race race){
        this.speed = DEFAULT_SPEED;
    };

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void moveForAnHour(){
        this.distanceTraveled += speed;
    }

     int generateSpeed(int maxSpeed, int minSpeed){
        return (int) (Math.floor(Math.random() * (maxSpeed - minSpeed)) + minSpeed);
    }
}

