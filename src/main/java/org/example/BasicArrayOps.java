package org.example;

import java.util.Arrays;
import java.util.Collections;

public class BasicArrayOps {
    public static void main(String[] args) {
        int[] intArr ={1,0,4}; // Array is not resizable, but you can change the value of an array at an index
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
        int[] intArr2= {0,-1,100,4,5};
        System.out.println(Arrays.toString(intArr2));
        Integer[] T_intArr2 = Arrays.stream(intArr2)
                .mapToObj(Integer::valueOf)
                .toArray(Integer[]::new);
        Arrays.sort(T_intArr2,Collections.reverseOrder());
        System.out.println(Arrays.toString(T_intArr2));


    }
}
