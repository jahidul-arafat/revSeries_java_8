package org.example.model;

public enum OliveColor {
    GREEN("green"), YELLOW("yellow"), RED("red");

    private final String color;

    OliveColor(String color) {
        this.color = color;
    }

    // Override the toString method
    @Override
    public String toString() {
        return this.color;
    }
}
