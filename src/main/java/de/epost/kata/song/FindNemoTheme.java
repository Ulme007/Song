package de.epost.kata.song;

import java.util.List;

public class FindNemoTheme extends Theme {

    public FindNemoTheme() {
        List<Animal> animals = getAnimals();
        animals.add(new Animal("Nemo", ""));
        animals.add(new Animal("Dorie", "That wriggled and wiggled and tickled inside her."));
        animals.add(new Animal("Marlin", "How absurd to swallow a Marlin."));
        animals.add(new Animal("Cora", "Fancy that to swallow a Cora!"));
        animals.add(new Animal("Rochen", "What a hog, to swallow a Rochen!"));
        animals.add(new Animal("Bruce", "I don't know how she swallowed a Bruce!"));
        animals.add(new Animal("Khan", ""));
    }
}
