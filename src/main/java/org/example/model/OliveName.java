package org.example.model;

public enum OliveName {
    // Define all the constants here
    // format: CONSTANT("literal string of the constant to be displayed")
    KALAMATA("kalamata"),
    JALAMATA("jalamata"),
    MALAMATA("malamata");

    // enum attributes
    private final String name;

    // constructor in the ENUM can only be called by the ENUM itself
    // so you cant add any PUBLIC keyword in it
    OliveName(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    // Print the object
    @Override
    public String toString() {
        return this.name;
    }
}
