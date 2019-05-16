package com.codecool.car_race;

import java.util.Random;


public class Weather {
    private boolean isRaining;

    public Weather() {
        setRaining();
    }

    public boolean getRain() {
        return isRaining;
    }

    private void setRaining() {
        Random r = new Random();
        isRaining = r.nextDouble() <= 0.3;
    }
}