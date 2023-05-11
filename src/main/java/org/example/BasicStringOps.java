package org.example;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Scanner;
import java.util.SortedMap;

public class BasicStringOps {
    public static void main(String[] args) {
        System.out.println("Welcome to Basic String Operations ....");

        // Prompt: Given an array of characters. convert this into a string
        char[] charArray = {'A', 'r', 'a', 'f', 'a', 't'};
        // print the elements of the array using foreach
        for (char c : charArray) {
            System.out.print(c);
        }
        System.out.println();

        // Convert the char array into a string
        String charStr = new String(charArray);
        System.out.printf("After Conversion: %s\n", charStr);

        // Prompt: Convert a string into character array
        char[] newCharArray = charStr.toCharArray();
        System.out.println(newCharArray); // you cant print a array using .printf() stmt.

        // Prompt: Given a long value 10_000_000. I want to print it in the format 10,000,000
        long number = 10_000_000l;
        NumberFormat nFormat = NumberFormat.getNumberInstance(); // define the format to print the number
        String formattedNumber = nFormat.format(number);         // use the defined format to covert the number into a string
        System.out.printf("Before Formatting: %s, After Formatting: %s", number, formattedNumber);
        System.out.println();

        // Prompt: Building String with string builder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(", ");
        sb.append("World");
        System.out.println(sb.toString());
        sb.insert(0, "Jahid!!! ");
        System.out.printf("String: %s, length: %s, Chat At: %s", sb.toString(), sb.length(), sb.charAt(sb.length() - 1));


        // lets delete the entire string we designed using stringbuilder
        System.out.println();
        sb.delete(0, sb.length()); // exclusive to sb.length(), this is upto sb.length()-1
        System.out.printf("After Deleting String: %s", sb.toString());

        // Prompt: Using for loop for 3 time, take user input and append each input to string builder.
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("User Input>> ");
            sb.append(sc.nextLine()).append(" ");
        }
        System.out.println(sb.toString());

        // Tips: Never use == operator for string comparison, always use string class's .equal() .equalIgnoreCase() method
        // Prompt: What's the difference between str1==str2 and str1.equals(str2)?
        // Prompt: Given two String variable having same value. Compare these two strings; make sure you are using a shorthand approach for comparison
        // == operation checks the reference equality, means whether two strings pointing the same memory locations
        // .equals() operator checks the value equality, means whether the value of the two strings are equal

        // == operator works great for primitive numbers, boolean and characters.

        // Technique Used by Java: String Interning
        // In Java, string interning is a technique used to improve performance and save memory by storing only one copy of each distinct string value,
        // which can be shared by multiple references.


        String str1 = "Hello";
        String str2 = "Hello"; // both pointing the same memory location in the heap in JVM as string "Hello" is already there.

        System.out.println(str1.equals(str2) ? "Matched" : "Not matched");

        // Prompt: When String equality checking can raise ambiguity
        // When an object is created with keyword 'new', Java allocates memory for that object in the HEAP!!!
        // HEAP is the region of memory that can be accessed by any thread that has a reference to them
        // HEAP is managed by JVM garbage collector, which periodically free up memory
        // Issues: Multi threaded concurrency issue can impact this as in the heap.
        String str3 = "Hello World";
        String str4 = new String("Hello World"); // a new memory is allocated in the HEAP. Didnt point to the earlier mem location of already defined string "Hello World"
        System.out.println(str3 == str4);     // False    // checking reference equality; through the values of the two strings are same, but they both pointing the different memory locations
        System.out.println(str3.equals(str4));// True // checking value equality






    }
}
