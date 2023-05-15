package org.example.model;

// Inheritance
public class Malamata extends Olive{
    public Malamata() {
        super(OliveName.MALAMATA, OliveColor.YELLOW, 50);
    }

    @Override
    public String getOrigin() {
        return "Japan";
    }
}
