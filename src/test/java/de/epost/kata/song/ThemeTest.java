package de.epost.kata.song;

import de.epost.kata.song.Theme.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThemeTest {

    @Test
    public void default_theme_contains_farm_animals() {
        Theme defaultTheme = new FarmTheme();
        List<Animal> animals = defaultTheme.getAnimals();

        assertAnimal(animals.get(0), "fly", "");
        assertAnimal(animals.get(1), "spider", "That wriggled and wiggled and tickled inside her.");
        assertAnimal(animals.get(2), "bird", "How absurd to swallow a");
        assertAnimal(animals.get(3), "cat", "Fancy that to swallow a");
        assertAnimal(animals.get(4), "dog", "What a hog, to swallow a");
        assertAnimal(animals.get(5), "cow", "I don't know how she swallowed a");
        assertAnimal(animals.get(6), "horse", "");
    }

    private void assertAnimal(Animal animal, String name, String rhyme) {
        assertEquals(name, animal.getName());
        assertEquals(rhyme, animal.getRhyme());
    }
}
