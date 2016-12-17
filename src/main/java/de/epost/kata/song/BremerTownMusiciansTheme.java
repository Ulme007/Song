package de.epost.kata.song;

import java.util.List;

public class BremerTownMusiciansTheme extends Theme {

    public BremerTownMusiciansTheme() {
        List<Animal> animals = getAnimals();
        animals.add(new Animal("Donkey", ""));
        animals.add(new Animal("Dog", "How absurd to swallow a"));
        animals.add(new Animal("Cat", "Fancy that to swallow a"));
        animals.add(new Animal("Cock", "What a hog, to swallow a"));
    }
}
