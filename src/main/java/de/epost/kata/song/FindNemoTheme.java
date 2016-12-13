package de.epost.kata.song;

import java.util.ArrayList;
import java.util.List;

public class FindNemoTheme extends Theme {
    List<String> animals = new ArrayList<String>();

    public FindNemoTheme() {
        animals.add("Nemo");
        animals.add("Dorie");
        animals.add("Marlin");
        animals.add("Cora");
        animals.add("Rochen");
        animals.add("Bruce");
        animals.add("Khan");
    }

    public List<String> getAnimals() {
        return animals;
    }
}
