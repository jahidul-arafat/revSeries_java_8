package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class CalMod {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Chose option: +,-,*,/ >>");
        String option = sc.next();

        switch (option){
            case "+"-> System.out.println(add(10d,20d,30d,40d));
            case "-"-> System.out.println(substraction(1d,2d,3d,4d));
            case "*"-> System.out.println(multiplication(1d,2d,3d,4d));
            case "/"-> System.out.println(division(10d,0d));
            default -> System.out.println("Wrong!!!!");
        }
    }

    public static Double add(Double... args){
        var numList = Arrays.asList(args);
        return numList.stream()
                .reduce(0d, Double::sum);
    }

    public static Double multiplication(Double... args){
        var numList = Arrays.asList(args);
        return numList.stream()
                .reduce(1d,(a,b)->a*b);
    }

    public static Double division(Double n1, Double n2){
        if (n2==0){
            try {
                throw new Exception("Division by Zero!!! .... Breaking   ");
            } catch (Exception e) {
                System.out.printf(e.getMessage());
                return 0d;
            }
        }
        return n1/n2;
    }

    public static Double substraction(Double... args){
        var numList = Arrays.asList(args);
        return numList.stream()
                .reduce((a, b) -> a - b)
                .orElse(0d);

    }


}
