package de.epost.kata.song;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThemeTest {

    @Test
    public void default_theme_contains_farm_animals() {
        Theme defaultTheme = new FarmTheme();
        assertEquals("fly", defaultTheme.getAnimals().get(0));
        assertEquals("spider", defaultTheme.getAnimals().get(1));
        assertEquals("bird", defaultTheme.getAnimals().get(2));
        assertEquals("cat", defaultTheme.getAnimals().get(3));
        assertEquals("dog", defaultTheme.getAnimals().get(4));
        assertEquals("cow", defaultTheme.getAnimals().get(5));
        assertEquals("horse", defaultTheme.getAnimals().get(6));
    }
}
