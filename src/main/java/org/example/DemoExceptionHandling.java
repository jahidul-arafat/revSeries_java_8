package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoExceptionHandling {
    public static void main(String[] args) {

        Integer[] numArr = {1,2,3};
        List<Integer> numList = new ArrayList<>();
        numList.addAll(Arrays.asList(numArr));
        numList.add(10);
        numList.add(0,-11);
        System.out.println(numList);
        numList.stream()
                .map(n->Math.pow(n,2))
                .toList()
                .forEach(n-> System.out.printf("%s, ",n));
        System.out.println();



        String demoStr = "Hello, World!!!";

        // convert the string to char array
        char[] charArr = demoStr.toCharArray();
        List<Character> charList = demoStr.chars()// means a stream of integers [1,2,3] for the corresponding character
                .mapToObj(c-> (char) c) // converting each char into Character object // converting the integer again back to char
                .map(Character::toUpperCase)
                .toList();
        //charList.add(0,'X'); // this will throw exception at runtime
                                            // this list is immutable as we get it from a fixed length array
        // List<Character> charListMutable = new ArrayList<>(Arrays.asList(charArr)); // cant be done
        List<Character> charListMutable = new ArrayList<>(charList);
        charListMutable.add(0,'X');
        System.out.println(charList);
        System.out.println(charListMutable);

        // Custom Exception Handling
        /*
        - Throw a custom exception if the charArr length is <10
        - Throw exception for ArrayIndexOutOfBound exception
        - Throw exception for StringIndexOutOfBound exception while creating substring
         */

        String myStr = "Welcome to exception handing simulation";

        try{
            if (myStr.length() <10){
                throw (new Exception("The length of your String is less than 10; We will not proceed NEXT...."));
            }

            // get the last character of the string
            var lastCharacter = myStr.charAt(myStr.length());

            // get a substring from the string
            var myStrSubStr = myStr.substring(myStr.length());
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("System Defined Exception Handling ....");
            e.printStackTrace();
        } catch (Exception e) { // general exception to call all kinds of
            System.out.println("Custom Exception Handling ....");
            e.printStackTrace();
        }


    }
}
