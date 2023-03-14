package com.challenger;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    String name;
    int maxWeight;

    Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    List<Location> performDeliveries(List<Location> locations) {
        List<Location> deliveries = new ArrayList<>();
        int currentWeight = 0;

        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            int locationWeight = location.getWeight();

            if (currentWeight + locationWeight <= maxWeight) {
                currentWeight += locationWeight;
                deliveries.add(locations.remove(i));
                i--;
            }
        }

        return deliveries;
    }
}
