package de.epost.kata.song;

import de.epost.kata.song.Theme.Animal;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Song {

    private static final String FIRST_STROPHE =
            "There was an old lady who swallowed a ${animal}.\n";

    private static final String INNER_STROPHE_START = "\n" +
            "There was an old lady who swallowed a ${animal};\n" +
            "${animalRhyme}\n";

    private static final String INNER_STROPHE_MIDDLE_WITH_COMMA =
            "She swallowed the ${animal1} to catch the ${animal},\n";

    private static final String INNER_STROPHE_MIDDLE_WITH_SEMICOLON =
            "She swallowed the ${animal1} to catch the ${animal};\n";

    private static final String LAST_STROPHE =
            "There was an old lady who swallowed a ${animal}...\n" +
                    "...She's dead, of course!";

    private static final String STROPHE_END =
            "I don't know why she swallowed a ${animal} - perhaps she'll die!\n";

    private Theme theme;

    Song() {
        this.theme = new FarmTheme();
    }

    Song(Theme theme) {
        this.theme = theme;
    }

    String playSong() {
        return playSong(theme.getAnimals());
    }

    private String playSong(List<Animal> animals) {
        String song = addFirstStrophe(animals.get(0));
        song += addInnerStrophes(animals);
        song += addLastStrophe(animals.get(animals.size() - 1));
        return song;
    }

    private String addFirstStrophe(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        return replace(FIRST_STROPHE, values) + replace(STROPHE_END, values);
    }

    private String addInnerStrophes(List<Animal> animals) {
        String middleSong = "";
        for (int i = 2; i < animals.size(); i++) {
            middleSong += addInnerStrophe(animals, i);
        }
        middleSong += "\n";

        return middleSong;
    }

    private String addInnerStrophe(List<Animal> animals, int number) {
        String start = addInnerStropheStart(animals.get(number - 1));
        String middle = addInnerStropheMiddle(animals, number);
        String end = addInnerStropheEnd(animals.get(0));

        return start + middle + end;
    }

    private String addInnerStropheStart(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());
        values.put("animalRhyme", animal.getRhyme());

        return replace(INNER_STROPHE_START, values);
    }

    private String addInnerStropheMiddle(List<Animal> animals, int number) {
        String result = "";
        for (int i = number - 1; i > 1; i--) {
            Map<String, String> values = new HashMap<>();
            values.put("animal1", animals.get(i).getName());
            values.put("animal", animals.get(i - 1).getName());

            result += replace(INNER_STROPHE_MIDDLE_WITH_COMMA, values);
        }

        if (number > 1) {
            Map<String, String> values = new HashMap<>();
            values.put("animal1", animals.get(1).getName());
            values.put("animal", animals.get(0).getName());

            result += replace(INNER_STROPHE_MIDDLE_WITH_SEMICOLON, values);
        }

        return result;
    }

    private String addInnerStropheEnd(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        return replace(STROPHE_END, values);
    }

    private String addLastStrophe(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        return replace(LAST_STROPHE, values);
    }

    private String replace(String template, Map<String, String> values) {
        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(template);
    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.playSong());
    }
}