package com.challenger;

public class Drone {
    String name;
    int maxWeight;

    public Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
    }

    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
