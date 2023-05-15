package org.example.ops;

import org.example.model.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class OliveSim {
    public static void main(String[] args) {
        List<Olive> oliveList = getOlives();


        getOliveStat(oliveList);


    }


    private static void getOliveStat(List<Olive> oliveList) {
        Press press = new OlivePress();
        press.setPreexistingOil(100); // i.e. we already have 100L oil in the container

        // get the preexisting oil in the container
        System.out.println(press.getPreexistingOil());
        // get the total oil
        System.out.println(press.getOil(oliveList));

        // curshing the olives
        press.crushOlives(oliveList);

        // get the oil by category "Name"
        // {A=6, B=26, C=10}
        // approach-01
        System.out.println(press.getOilByName(oliveList));

        // get the oil by category: color
        System.out.println(press.getOilByColor(oliveList));

        // get the current oil in the container now

    }

    @NotNull
    private static List<Olive> getOlives() {
        // Create an encapsulated olive press system
        // Olive will be pressed in the OlivePress to get the oil
        // Create a List of Olives
        List<Olive> oliveList = new ArrayList<>();
//        oliveList.add(new Olive(OliveName.KALAMATA, OliveColor.YELLOW, 3));
//        oliveList.add(new Olive(OliveName.KALAMATA, OliveColor.YELLOW, 13));
//        oliveList.add(new Olive(OliveName.JALAMATA, OliveColor.GREEN, 3));
//        oliveList.add(new Olive(OliveName.JALAMATA, OliveColor.GREEN, 13));
//        oliveList.add(new Olive(OliveName.MALAMATA, OliveColor.RED, 10));

        // add 2 kalamata olive in the list
        oliveList.add(new Kalamata());
        oliveList.add(new Kalamata());

        // add 2 jalamata olive in the list
        oliveList.add(new Jalamata());
        oliveList.add(new Jalamata());

        // add 1 malamata olive in the list
        oliveList.add(new Malamata());

        return oliveList;
    }


}
