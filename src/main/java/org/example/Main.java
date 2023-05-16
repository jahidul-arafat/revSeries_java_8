package org.example;


public class Main {
    // method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // create a class named Olive with attributes "name" and "value" and override the toString method
    public static class Olive {
        // add two instance attributes: name and value
        private String name;

        // another attribute named "value"
        private int value;

        // constructor
        public Olive(String name, int value) {
            this.name = name;
            this.value = value;
        }

        // add the getter and setter
        public String getName() {
            return name;
        }

        // setter
        public void setName(String name) {
            this.name = name;
        }

        // getter
        public int getValue() {
            return value;
        }

        // setter
        public void setValue(int value) {
            this.value = value;
        }

        // toString method
        @Override
        public String toString() {
            return "Olive [name=" + name + ", value=" + value + "]";
        }
    }





    public static void main(String[] args) {

        System.out.println("Tabnine AI Assistance Simulation for the Intellij IDEA");
        System.out.println("Simulation by Jahidul Arafat");









    }
}