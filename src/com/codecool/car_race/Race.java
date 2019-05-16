package com.codecool.car_race;

import com.codecool.car_race.Vehicle.Car;
import com.codecool.car_race.Vehicle.Motorcycle;
import com.codecool.car_race.Vehicle.Truck;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private boolean isRaining;

    private List<Car> cars = new ArrayList<>();
    private List<Motorcycle> motorcycles = new ArrayList<>();
    private List<Truck> trucks = new ArrayList<>();
    private static int HOURS_OF_RACE = 50;

    Race() {
        isRaining = false;
    }

    public void listVehicles(ArrayList<Car> listOfCars, ArrayList<Motorcycle> listOfMotors, ArrayList<Truck> listOfTrucks) {
        cars = listOfCars;
        motorcycles = listOfMotors;
        trucks = listOfTrucks;
    }

    public boolean getIsRaining() {
        return isRaining;
    }

    public void simulateRace(Race race) {

        for (int i = 0; i < HOURS_OF_RACE; i++) {
            isRaining();

            for (Car car : cars) {
                car.prepareForLap(race);
                car.moveForAnHour();
            }
            for (Motorcycle motorcycle : motorcycles) {
                motorcycle.prepareForLap(race);
                motorcycle.moveForAnHour();
            }
            for (Truck truck : trucks) {
                truck.prepareForLap(race);
                truck.moveForAnHour();
            }
        }
    }

    public void printRaceResults() {
        System.out.println("RACE RESULTS");
        System.out.println("=========================================================================");
        System.out.println("Cars:");
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getDistanceTraveled() + " km(s)");
        }
        System.out.println("\n");
        System.out.println("Motorcycles:");
        for (Motorcycle motorcycle : motorcycles) {
            System.out.println(motorcycle.getName() + ": " + motorcycle.getDistanceTraveled() + " km(s)");
        }
        System.out.println("\n");
        System.out.println("Trucks:");
        for (Truck truck : trucks) {
            System.out.println(truck.getName() + ": " + truck.getDistanceTraveled() + " km(s)");
        }
    }

    public void isRaining() {
        Weather weather = new Weather();
        if (weather.getRain()) {
            isRaining = true;
        }
    }

    public boolean isThereBrokenTruck() {
        boolean brokenTruck = false;
        for (Truck truck : trucks) {
            if (truck.getBreakdownTurnsLeft() > 0) brokenTruck = true;
        }
        return brokenTruck;
    }

}
