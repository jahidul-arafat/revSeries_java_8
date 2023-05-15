package org.example.ops;

import org.example.model.Olive;
import org.example.model.Press;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Press --> is an interface
// Object oriented Contract-based architecture
public class OlivePress implements Press {

    // check if oil is already there in the container
    // if so, then sum this preexistingOil with the oil we get from pressing the olives
    // Instance attribute
    private int currentOil;

    // Custom Methods -- Business Logic
    // Get total oil after crushing the olives
    public int getOil( List<Olive> oliveList) {
        var oilIfOlivePressed= oliveList
                .stream()
                .mapToInt(Olive::getOil)
                .sum();
        return currentOil+oilIfOlivePressed;
    }

    // Get oil by Category: OliveName
    public Map<String, Integer> getOilByName(List<Olive> oliveList){
        return oliveList.stream()
                .collect(Collectors.groupingBy(Olive::getName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey().getName(),
                        (entry)-> entry.getValue()
                                .stream()
                                .mapToInt(Olive::getOil)
                                .sum()
                ));
    }

    // Get oil by Category: OliveColor
    public Map<String,Integer> getOilByColor(List<Olive> oliveList){
        return oliveList.stream()
                .collect(Collectors.groupingBy(o -> o.getColor().toString(),
                        Collectors.summingInt(Olive::getOil)));
    }

    public void setPreexistingOil(int preexistingOil) {
        this.currentOil=preexistingOil;
    }

    @Override
    public int getPreexistingOil() {
        return this.currentOil;
    }

    @Override
    public void crushOlives(List<Olive> oliveList) {
        oliveList
                .forEach(olive -> olive.crush());
    }

    public int getOilInContainerAfterAllOliveCrush() {
        return 0;
    }

    public int getCurrentOil() {
        return currentOil;
    }
}
