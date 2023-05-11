package org.example;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagingProgramFlows {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Choose your simulation model \n" +
                "1. Simple \n" +
                "2. List/Array Based\n" +
                "3. Pass as Val\n" +
                "4. Pass as Ref\n" +
                "5. Pass the String!! As Value or As Ref? " +
                "What HEAP memory says? (Hint: Immutable) >>");
        var response = sc.nextInt();

        switch (response) {
            case 1 -> simpleDesign();
            case 2 -> advancedDesign();
            case 3 -> passAsValSim(); // simple primitive objects are passed as values
            case 4 -> passAsRefSim();   // complex primitive objects are passed as reference.
                                        // Array -> is a complex object
            case 5-> isStringValOrRef();
            default -> System.out.println("Wrong Option Chosen!!!");
        }
    }

    public static void isStringValOrRef(){
        String name="Jahid";
        System.out.printf("Before Call: %s\n", name);
        stringAlwaysAsValNotRefImmutable(name);
        System.out.printf("After Call: %s\n", name);

    }

    public static void stringAlwaysAsValNotRefImmutable(String name){
        name = "Arafat//New";
        System.out.printf("In Method/String: %s\n",name);

    }
    public static void passAsValSim() {
        var value = 10;
        System.out.printf("Before Call: %s\n", value);
        incrementValue(value);
        System.out.printf("After Call: %s\n", value);

    }

    public static void passAsRefSim() {
        int[] valueArr = {10, 20, 30};
        System.out.printf("Before Call: %s\n", valueArr[0]);
        incrementValue(valueArr);
        System.out.printf("After Call: %s\n", valueArr[0]);

    }


    public static void simpleDesign() {
        var n1 = getInput();
        var n2 = getInput();
        System.out.println(add(n1, n2));
    }

    public static void advancedDesign() {
        List<Double> inputList = new ArrayList<>();
        System.out.println("How Many Inputs");
        var totalInputs = sc.nextInt();

        int counter = 0;
        while (counter < totalInputs) {
            inputList.add(getInput());
            counter += 1;
        }

        System.out.println(inputList);
        System.out.println(add(inputList));

    }


    public static Double getInput() {
        System.out.print("Enter Input: ");
        return sc.nextDouble();

    }

    // Method overloading - Method overloading happens at compile time
    // when Method overriding (parent class- child class) - happens at Runtime
    public static Double add(Double n1, Double n2) {
        System.out.println("2 par function");
        return n1 + n2;
    }

    public static Double add(Double... args) {
        System.out.println("Any par function");
        var numList = Arrays.asList(args);
        System.out.println(numList);
        return numList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public static  Double add(List<Double> inputList) {
        System.out.println("List<Double> function ...");
        return inputList.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    // Arguments passed into a method, passed by Reference or passed by Value!!!!
    // Passed by value - a copy of the original object is passed. Alter will not impact original
    // Passed by References - receives a reference to the original object. Alter will impact original
    // In Java, variables are always passed by Copy!!! (Passed by value) - Alter will not impact original!!!!!
    public static void incrementValue(int value) {
        value++;
        System.out.printf("In Method (Pass as Value): %s\n", value);
    }

    public static void incrementValue(int[] valueArr) {
        valueArr[0]++;
        System.out.printf("In Method(Pass ad Ref): %s\n", valueArr[0]);
    }


}
