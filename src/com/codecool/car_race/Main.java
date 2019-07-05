package com.codecool.car_race;


import com.codecool.car_race.Vehicle.Car;
import com.codecool.car_race.Vehicle.Motorcycle;
import com.codecool.car_race.Vehicle.Truck;
import com.codecool.car_race.Vehicle.Vehicle;


import java.util.ArrayList;
import java.util.List;

public class Main {

    static int numberMotorcycle = 1;
    static final int NUMBER_OF_VEHICLES = 3;

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
        List<Vehicle> vehiclesList = new ArrayList<>();


        for (int i = 0; i < NUMBER_OF_VEHICLES; i++) {

            vehiclesList.add(new Car());
            vehiclesList.add(new Motorcycle(numberMotorcycle++));
            vehiclesList.add(new Truck());

        }

        race.listVehicles(vehiclesList);
    }
    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Race race = new Race();
        createVehicles(race);

        race.simulateRace(race);
        race.printRaceResults();
    }
}
