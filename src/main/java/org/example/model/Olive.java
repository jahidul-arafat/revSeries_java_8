package org.example.model;

public abstract class Olive {

    // Instance attributes
    private OliveName name;
    private OliveColor color;
    private int oil;

    // Constructor
    // Null constructor is default
    // Constructor-01: All attribute constructor
    public Olive(OliveName name, OliveColor color, int oil) {
        this.name = name;
        this.color = color;
        this.oil = oil;
    }

    // Constructor-02: Single attribute constructor
    public Olive(OliveName name) {
        this.name = name;
    }

    // Getter and Setter


    public OliveName getName() {
        return name;
    }

    public void setName(OliveName name) {
        this.name = name;
    }

    public OliveColor getColor() {
        return color;
    }

    public void setColor(OliveColor color) {
        this.color = color;
    }

    public int getOil() {
        return oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void crush(){
        String crushMsg = String.format("%s, from %s, %s of color, oil %s units",
                name,getOrigin(),getColor(), getOil());
        System.out.println(crushMsg);
    }


    // custom methods

    // Every subclass of this Olive class i.e. class Kalamata, Jalamata and Malamata must declare its origin
    // means, they whould implement this getOrigin() method
    public abstract String getOrigin();

    // toString
    @Override
    public String toString() {
        return "Olive{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", oil=" + oil +
                ", origin="+ getOrigin()+
                '}';
    }
}
