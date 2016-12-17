package de.epost.kata.song;

import java.util.List;

public class FarmTheme extends Theme {

    public FarmTheme() {
        List<Animal> animals = getAnimals();
        animals.add(new Animal("fly", ""));
        animals.add(new Animal("spider", "That wriggled and wiggled and tickled inside her."));
        animals.add(new Animal("bird", "How absurd to swallow a"));
        animals.add(new Animal("cat", "Fancy that to swallow a"));
        animals.add(new Animal("dog", "What a hog, to swallow a"));
        animals.add(new Animal("cow", "I don't know how she swallowed a"));
        animals.add(new Animal("horse", ""));
    }
}
