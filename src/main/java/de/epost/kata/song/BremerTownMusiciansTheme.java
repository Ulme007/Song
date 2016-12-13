package de.epost.kata.song;

import java.util.ArrayList;
import java.util.List;

public class BremerTownMusiciansTheme extends Theme {

    private final ArrayList<String> animals;

    public BremerTownMusiciansTheme() {
        animals = new ArrayList<String>();
        animals.add("Donkey");
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Cock");
    }

    public List<String> getAnimals() {
        return animals;
    }
}
