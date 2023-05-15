package org.example.model;


import java.util.List;
import java.util.Map;

// At interface, dont implement the methods
// Interfaces are used in androd for even-handing, call-back methods etc.

public interface Press {
    public int getOil( List<Olive> oliveList);
    public Map<String, Integer> getOilByName(List<Olive> oliveList);
    public Map<String,Integer> getOilByColor(List<Olive> oliveList);
    public void setPreexistingOil(int preexistingOil);
    public int getPreexistingOil();
    public void crushOlives(List<Olive> oliveList);
}
