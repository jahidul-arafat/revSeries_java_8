package org.example.model;

// olive Kalamata is extending the Parent class Olive

// Inheritance
public class Kalamata extends Olive{
    public Kalamata() {
        super(OliveName.KALAMATA, OliveColor.GREEN, 2);
    }

    @Override
    public String getOrigin() {
        return "Italy";
    }
}
