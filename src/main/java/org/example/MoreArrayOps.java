package org.example;

import java.util.*;

public class MoreArrayOps {
    public static void main(String[] args) {
        String[][] state2DArr = new String[3][2];
        state2DArr[0][0]="BD";
        state2DArr[0][1]="Dhaka";
        state2DArr[1][0]="India";
        state2DArr[1][1]="Delhi";
        state2DArr[2][0]="Srilanka";
        state2DArr[2][1]="Colombo";

        // Create a StringBuilder object

        for (int i = 0; i < state2DArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("The capital of ")
                    .append(state2DArr[i][0])
                    .append(" is ")
                    .append(state2DArr[i][1]);
            System.out.println(sb);
        }

        // Ordered Data
        // Non-resizable array
        // List created using Array.asList() is fixed in length and not resizable
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
        // myList.add(11); // not possible to add new elements as size is fixed
        System.out.println(myList.get(0));
        System.out.println(myList);


        // Resizable array
        // ArrayList and HashMap
        // Diamond operator
        // List --> is an Interface
        // ArrayList --> is a class implements List
        List<String> strList = new ArrayList<>(); // ArrayList is a concrete implementation of strList
        strList.add("Billy");
        strList.add("Cilly");
        System.out.println(strList);
        System.out.printf("The pos of Billy is %s\n", strList.indexOf("Billy"));


        // Unordered Data
        // Using HashMap --> implements Map interface
        // Map<Key, Value>
        Map<String,String> myMap = new HashMap<>();
        myMap.put("0","Billy");
        myMap.put("1","Cilly");
        System.out.println(myMap);
        System.out.println(myMap.get("0"));

        // Iterating through the Collection elements either ordered or unordered
        // Using Method Reference
        // no need to create additional Stream here
        strList.forEach(System.out::println);

        myMap.entrySet()
                .stream()
                .forEach(entry-> System.out.println(entry.getKey()+"-->"+ entry.getValue()));

        // iterate over the list using Iterator
        // Define the iterator first
        Iterator<String> listIterator = strList.iterator();
        while (listIterator.hasNext()){
            // get the item from the iteration
            var item = listIterator.next();
            System.out.println(item);
        }

        // but do we really need an additional object to iterate over a list
        for (String item:strList
             ) {
            System.out.println(item);
        }

    }
}
