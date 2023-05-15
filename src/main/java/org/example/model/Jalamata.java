package org.example.model;

// Inheritance
public class Jalamata extends Olive{
    public Jalamata() {
        super(OliveName.JALAMATA, OliveColor.RED, 10);
    }

    @Override
    public String getOrigin() {
        return "Bangladesh!!!";
    }
}
