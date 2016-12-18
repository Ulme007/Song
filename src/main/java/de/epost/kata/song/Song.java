package de.epost.kata.song;

import de.epost.kata.song.Theme.Animal;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Song {

    private static final String FIRST_STROPHE =
            "There was an old lady who swallowed a ${animal}.\n";

    private static final String SECOND_STROPHE = "\n" +
            "There was an old lady who swallowed a ${animal1};\n" +
            "${animalRhyme1}\n" +
            "She swallowed the ${animal1} to catch the ${animal};\n";

    private static final String INNER_STROPHE_START = "\n" +
            "There was an old lady who swallowed a ${animal};\n" +
            "${animalRhyme}\n";

    private static final String INNER_STROPHE_MIDDLE_WITH_COMMA =
            "She swallowed the ${animal} to catch the ${animal1},\n";

    private static final String INNER_STROPHE_MIDDLE_WITH_SEMICOLON =
            "She swallowed the ${animal} to catch the ${animal1};\n";

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
        song += addMiddleStrophes(animals);
        song += addLastStrophe(animals.get(animals.size() - 1));
        return song;
    }

    private String addFirstStrophe(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(FIRST_STROPHE) + sub.replace(STROPHE_END);
    }

    private String addMiddleStrophes(List<Animal> animals) {
        String middleSong = addSecondStrophe(animals);

        for (int i = 3; i < animals.size(); i++) {
            middleSong += addThirdStrophe(animals, i);
        }

        middleSong += "\n";

        return middleSong;
    }

    private String addSecondStrophe(List<Animal> animals) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animalRhyme1", animals.get(1).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(SECOND_STROPHE) + sub.replace(STROPHE_END);
    }

    private String addThirdStrophe(List<Animal> animals, int number) {
        String start = addInnerStropheStart(animals.get(number - 1));
        String middle = addInnerStropheMiddle(animals, number);
        String end = addInnerStropheEnd(animals.get(0));

        return start + middle + end;
    }

    private String addInnerStropheStart(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());
        values.put("animalRhyme", animal.getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(INNER_STROPHE_START);
    }

    private String addInnerStropheMiddle(List<Animal> animals, int number) {
        String result = "";
        for (int i = number - 1; i > 1; i--) {
            Map<String, String> values = new HashMap<>();
            values.put("animal", animals.get(i).getName());
            values.put("animal1", animals.get(i - 1).getName());

            StrSubstitutor sub = new StrSubstitutor(values);
            result += sub.replace(INNER_STROPHE_MIDDLE_WITH_COMMA);
        }

        if (number > 1) {
            Map<String, String> values = new HashMap<>();
            values.put("animal", animals.get(1).getName());
            values.put("animal1", animals.get(0).getName());

            StrSubstitutor sub = new StrSubstitutor(values);
            result += sub.replace(INNER_STROPHE_MIDDLE_WITH_SEMICOLON);
        }

        return result;
    }

    private String addInnerStropheEnd(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(STROPHE_END);
    }

    private String addLastStrophe(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(LAST_STROPHE);
    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.playSong());
    }
}