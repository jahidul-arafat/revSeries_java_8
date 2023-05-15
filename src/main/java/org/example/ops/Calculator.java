package org.example.ops;

import org.example.utilities.MathHelper;

import java.util.Scanner;

// First level of encapsulation
// Breaking method out in their own library, so that they can be called from anywhere.
public class Calculator {

    // empty constructor
    public Calculator() {
    }

    protected void calculate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chose option: +,-,*,/ >>");
        String option = sc.next();

        switch (option){
            case "+"-> System.out.println(MathHelper.add(1d,2d,3d,4d));
            case "-"-> System.out.println(MathHelper.subtraction(1d,2d,3d,4d));
            case "*"-> System.out.println(MathHelper.multiplication(1d,2d,3d,4d));
            case "/"-> System.out.println(MathHelper.division(10d,0d));
            default -> System.out.println("Wrong!!!!");
        }
    }




}
