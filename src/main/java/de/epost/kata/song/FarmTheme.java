package de.epost.kata.song;

import java.util.ArrayList;
import java.util.List;

public class FarmTheme extends Theme {

    List<String> animals = new ArrayList<String>();

    public FarmTheme() {
        animals.add("fly");
        animals.add("spider");
        animals.add("bird");
        animals.add("cat");
        animals.add("dog");
        animals.add("cow");
        animals.add("horse");
    }

    public List<String> getAnimals() {
        return animals;
    }
}
