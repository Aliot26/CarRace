package com.codecool.car_race.Vehicle;

import com.codecool.car_race.Race;

public abstract class Vehicle {

    protected int distanceTraveled;
    protected int speed;


    public void prepareForLap(Race race){
        this.speed = 100;
    };

    public void moveForAnHour(){
        this.distanceTraveled += speed;
    }
}

