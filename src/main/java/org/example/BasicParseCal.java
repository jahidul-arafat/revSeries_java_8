package org.example;

import java.util.Scanner;

public class BasicParseCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // to avoid parsing use sc.nextDouble()

        System.out.print("Input 1: ");
        var input1 = sc.next();
        double parsedIn1= Double.parseDouble(input1);   // redundant

        System.out.print("Input 2: ");
        var input2 = sc.next();
        double parsedIn2= Double.parseDouble(input2);   // redundant

        System.out.printf("Answer: %s", parsedIn1+parsedIn2);

        // No Error handling


    }
}
