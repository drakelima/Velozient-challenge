package com.challenger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DroneDeliveryService {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Path.of("input.txt"));

            List<Drone> drones = new ArrayList<>();
            String[] droneInfo = lines.get(0).split(",");
            for (int i = 0; i < droneInfo.length; i += 2) {
                drones.add(new Drone(droneInfo[i], Integer.parseInt(droneInfo[i + 1])));
            }

            List<Location> locations = lines.subList(1, lines.size()).stream()
                    .map(s -> s.split(","))
                    .map(arr -> new Location(arr[0], Integer.parseInt(arr[1])))
                    .sorted(Comparator.comparingInt(Location::getWeight).reversed())
                    .collect(Collectors.toList());

            for (Drone drone : drones) {
                int tripCounter = 1;
                System.out.println(drone.name);

                while (!locations.isEmpty()) {
                    List<Location> deliveries = drone.performDeliveries(locations);
                    if (!deliveries.isEmpty()) {
                        System.out.println("Trip #" + tripCounter);
                        tripCounter++;
                        System.out.println(deliveries.stream().map(Location::getName).collect(Collectors.joining(",")));
                    } else {
                        break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
