package org.example.utilities;

import java.util.Arrays;

public class MathHelper {
    public static Double add(Double... args){
        return Arrays.stream(args)
                .reduce(0d, Double::sum);
    }

    public static Double subtraction(Double... args){
        return Arrays.stream(args)
                .reduce(0d,(a,b)-> a-b);

    }

    public static Double multiplication(Double... args){
        return Arrays.stream(args)
                .reduce(1d,(a,b)->a*b);
    }

    public static Double division(Double n1, Double n2){
        if (n2==0){
            try {
                throw new Exception("Cant Divide by ZERO!!!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return 0d;
            }
        }
        return n1/n2;
    }

    public Double max(Double... args){
        return Arrays.stream(args)
                .reduce(0d,Double::max);
    }

    public Double min(Double... args){
        return Arrays.stream(args)
                .reduce(0d,Double::min);
    }
}
