package de.epost.kata.song;

import java.util.ArrayList;
import java.util.List;

public abstract class Theme {

    public static class Animal {
        private final String name;
        private final String rhyme;

        public Animal(String name, String rhyme) {
            this.name = name;
            this.rhyme = rhyme;
        }

        public String getName() {
            return name;
        }

        public String getRhyme() {
            return rhyme;
        }
    }

    List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }
}
