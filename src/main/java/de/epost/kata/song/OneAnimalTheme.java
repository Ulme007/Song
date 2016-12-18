package de.epost.kata.song;

import java.util.List;

public class OneAnimalTheme extends Theme {
    public OneAnimalTheme() {
        List<Animal> animals = getAnimals();
        animals.add(new Animal("fly", ""));
    }
}
