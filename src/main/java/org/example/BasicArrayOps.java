package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Questions:
#daily_java_blog

How does a simple array of non-natural order sorting lead you to a bundle of questions?
Given an int[] intArr={2,3,1,0,-1}, you must sort it into descending order.

** Arrays natural order sorting is in ascending mode.

Input: {2,3,1,0,-1}
Output: {3,2,1,0,-1}

(a) Why can't I use the below syntax when doing this reverse sort?
Arrays.sort(intArr, Collections.reverseSort());

(b) Why it's giving me the reasoning of
no instance(s) of type variable(s) T exists so that int[] conforms to T[]

(c) How are we going to transform this int[] into Integer[] to resolve the reasoning? Is there any correlation between T[] to Integer[]? Is there any superclass-subclass relationship? Can you correlate the T to be an Object and the Integer to be a subclass of that object?
(d) Why did we used .boxed() in one solution and .mapToObj() in an alternative solution? Does it impact your program's performance when the array size is immense?
(e) Can you correlate the .boxed() with Terminal operations like forEach(), reduce(), collect(), max(), min() and .mapToObj() with Intermediate operator i.e. filter(), map(), sorted(), distinct() etc.
(f) How does the terminal operation trigger the intermediate operation in this execution?
(g) Is it like intermediate operations transform the input stream into another stream while terminal operations produce a final result or a side-effect.
(h) why do we need to transform IntStream into Stream<Integer> when doing this non-natural order sorting of Array elements, when IntStream provides optimized methods for handling int values, which can lead to better performance compared to using the Stream<Integer> for Integer objects?
(I) How can you convert an IntStream to a Steam<Integer> using boxed() object which later could help you transforming int[] into Integer[] object type?
(j) When both .boxed() and .mapToObj() methods create Stream<Integer>, are they the same?

** 𝒆𝒂𝒄𝒉 𝒐𝒇 𝒕𝒉𝒆𝒔𝒆 𝒒𝒖𝒆𝒔𝒕𝒊𝒐𝒏𝒔 𝒘𝒐𝒖𝒍𝒅 𝒃𝒆 𝒂 𝒑𝒓𝒐𝒎𝒑𝒕 𝒇𝒐𝒓 𝒚𝒐𝒖 𝒊𝒏 𝑮𝑷𝑻
#java #array #sort #stream #boxed #prompt_with_me #promptengineering
 */

public class BasicArrayOps {
    public static void main(String[] args) {
        int[] intArr = {1, 0, 4}; // Array is not resizable, but you can change the value of an array at an index
        System.out.println(intArr[0]);

        // natural order sort of an array
        Arrays.sort(intArr); // here, array is passed as reference as the object wrapper in the memory of the heap.

        // reverse order sort of an array
        // so this is not the simplest way to do a reverse sort
        // we need to provide
        // requires a generic type array object, not int type array object
        //Arrays.sort(intArr, Collections.reverseOrder()); // this will throw an compile time error
        // reason: no instance(s) of type variable(s) T exist so that int[] conforms to T[]
        // Solution
        // Convert an int array into Integer array
        // as Integer array will be required to sort the array in reverse order
        // Way-01
        // Integer is a subclass of Object. That's why when the reverse sort required T[], we supplied Integer[] not int[]
        Integer[] T_intArr = Arrays.stream(intArr)
                .boxed()
                // to convert each int primitive int into its corresponding Integer object // this introduces an additional overhead of introducing additional stream
                .toArray(Integer[]::new);
        Arrays.sort(T_intArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(T_intArr));

        // Way-02: More efficient if the array size if very large
        // similar in performance to way-01 for small array size
        int[] intArr2 = {0, -1, 100, 4, 5};
        System.out.println(Arrays.toString(intArr2));
        Integer[] T_intArr2 = Arrays.stream(intArr2)
                .mapToObj(Integer::valueOf)
                .toArray(Integer[]::new);
        Arrays.sort(T_intArr2, Collections.reverseOrder());
        System.out.println(Arrays.toString(T_intArr2));

        // String Array
        String[] strArray = {"A", "C", "BB", "B","c"};
        System.out.println(Arrays.toString(strArray));

        // Sort the String array into alphabetic order
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));

        // Sort the array into descending order of their length
        // Lambda expression requires an explicit target type
        // Comparator.comparing(Function::Mandatory_Param, Other_Comparator:: Optional)
        // Comparator.comparing(String::length) represents Comparator.comparing(String::length, null) --> natural order sorting
        Comparator<Integer> lambda_lengthComparator = (s1, s2) -> Integer.compare(s2, s1);
        Comparator<String> strLengthComparator =
                Comparator.comparing(String::length, lambda_lengthComparator);
        Arrays.sort(strArray, strLengthComparator);
        System.out.println(Arrays.toString(strArray));

        // To simply reverse an Array


        // Sort by first Character
        Function<String, Character> function_firstLetter = (String s) -> s.charAt(0);
        Comparator<String> strFirstLetterComparator = Comparator.comparing(function_firstLetter);
        strFirstLetterComparator = strFirstLetterComparator.reversed(); // lets reverse it, so that
        Arrays.sort(strArray, strFirstLetterComparator);
        System.out.printf("Sort by first letter (reverse): %s\n", Arrays.toString(strArray));


        // Declaring the initial size of an array
        int[] sizedArray = new int[10];
        sizedArray[0]=10;
        sizedArray[2]=20;
        System.out.println(Arrays.toString(sizedArray));

        // Copy the portion of an array to another array
        var copiedSizedArray = new int[3];
        System.arraycopy(sizedArray,0,copiedSizedArray,0,3);
        System.out.println(Arrays.toString(copiedSizedArray));

        // another way of copying an array
        int[] destinationArray = Arrays.copyOf(sizedArray,sizedArray.length);
        System.out.println(Arrays.toString(destinationArray));

        // Array to List
        String[] sourceArray = {"Jahid","Arafat", "Hello"};
        List<String> sourceList = Arrays.asList(sourceArray);

        // Function to convert the 2nd letter of each string to Uppercase and rest as lowercase
        Function<String, String> toMixedCase = s -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == 1) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            return sb.toString();
        };

        var lowerCaseList=sourceList.stream()
                .map(toMixedCase)
                .toList();
        System.out.println(lowerCaseList);


    }
}
