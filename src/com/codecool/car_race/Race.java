package com.codecool.car_race;

import com.codecool.car_race.Vehicle.Car;
import com.codecool.car_race.Vehicle.Motorcycle;
import com.codecool.car_race.Vehicle.Truck;
import com.codecool.car_race.Vehicle.Vehicle;

import java.util.List;

public class Race {
    private boolean isRaining;
    private List<Vehicle> vehicles;
    private static int HOURS_OF_RACE = 50;

    Race() {
        isRaining = false;
    }

    void listVehicles(List<Vehicle> listOfVehicles) {
        vehicles = listOfVehicles;
    }

    public boolean getIsRaining() {
        return isRaining;
    }

    void simulateRace(Race race) {

        for (int i = 0; i < HOURS_OF_RACE; i++) {
            isRaining();

            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(race);
                vehicle.moveForAnHour();
            }

        }
    }

    void printRaceResults() {
        System.out.println("RACE RESULTS");
        System.out.println("=========================================================================");
        System.out.println("Cars:");


        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println(vehicle.getName() + ": " + vehicle.getDistanceTraveled() + " km");
            }
        }

        System.out.println("\n");
        System.out.println("=========================================================================");
        System.out.println("Motorcycles:");

        vehicles.stream()
                .filter(item -> item instanceof Motorcycle)
                .forEach(System.out::println);


        System.out.println("\n");
        System.out.println("=========================================================================");
        System.out.println("Trucks:");

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                System.out.println(vehicle.getName() + ": " + vehicle.getDistanceTraveled() + " km");
            }
        }
    }

   private void isRaining() {
        Weather weather = new Weather();
        if (weather.getRain()) {
            isRaining = true;
        }
    }

    public boolean isThereBrokenTruck() {
        boolean brokenTruck = false;
        for (Vehicle truck : vehicles) {
            if (truck instanceof Truck) {
                if (((Truck) truck).getBreakdownTurnsLeft() > 0) {
                    brokenTruck = true;
                }
            }
        }
        return brokenTruck;
    }

}
