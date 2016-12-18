package de.epost.kata.song;

import java.util.List;

public class BremerTownMusiciansTheme extends Theme {

    public BremerTownMusiciansTheme() {
        List<Animal> animals = getAnimals();
        animals.add(new Animal("Donkey", ""));
        animals.add(new Animal("Dog", "That wriggled and wiggled and tickled inside her."));
        animals.add(new Animal("Cat", "How absurd to swallow a Cat."));
        animals.add(new Animal("Cock", "What a hog, to swallow a Cock!"));
    }
}
