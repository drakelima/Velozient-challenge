package com.challenger;

public class Location {
    private String name;
    private int weight;

    Location(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }
}
