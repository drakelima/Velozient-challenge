package com.challenger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DroneDeliveryService {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Path.of("input.txt"));
            String[] droneData = lines.get(0).split(",");
            List<String> locationLines = lines.subList(1, lines.size());

            List<Drone> drones = new ArrayList<>();
            List<Location> locations = new ArrayList<>();

            for (int i = 0; i < droneData.length; i += 2) {
                drones.add(new Drone(droneData[i], Integer.parseInt(droneData[i + 1])));
            }

            for (String locationLine : locationLines) {
                String[] locationParts = locationLine.split(",");
                locations.add(new Location(locationParts[0], Integer.parseInt(locationParts[1])));
            }

            locations.sort(Comparator.comparing(Location::getWeight).reversed());
            drones.sort(Comparator.comparing(Drone::getMaxWeight).reversed());

            for (Drone drone : drones) {
                int trip = 1;
                boolean hasTrip = false;

                while (!locations.isEmpty()) {
                    int currentWeight = 0;
                    List<Location> assignedLocations = new ArrayList<>();

                    for (Location location : locations) {
                        if (currentWeight + location.weight <= drone.maxWeight) {
                            currentWeight += location.weight;
                            assignedLocations.add(location);
                        }
                    }

                    if (assignedLocations.isEmpty()) {
                        break;
                    }

                    if (!hasTrip) {
                        System.out.println(drone.name);
                        hasTrip = true;
                    }

                    System.out.print("Trip #" + trip + "\n");
                    assignedLocations.forEach(location -> System.out.print(location.name + ","));

                    System.out.println();
                    trip++;

                    locations.removeAll(assignedLocations);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
