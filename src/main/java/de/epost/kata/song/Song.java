package de.epost.kata.song;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Song {

    private static final String lastStropheTemplate =
            "There was an old lady who swallowed a ${animal}...\n" +
                    "...She's dead, of course!";

    private static final String firstStropheTemplate =
            "There was an old lady who swallowed a ${animal}.\n" +
                    "I don't know why she swallowed a ${animal} - perhaps she'll die!\n";


    private String songTemplate =
//            "\n" +
//                    "There was an old lady who swallowed a @1@;\n" +
//                    "That wriggled and wiggled and tickled inside her.\n" +
//                    "She swallowed the @1@ to catch the @0@;\n" +
//                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
//                    "\n" +
//                    "There was an old lady who swallowed a @2@;\n" +
//                    "How absurd to swallow a @2@.\n" +
//                    "She swallowed the @2@ to catch the @1@,\n" +
//                    "She swallowed the @1@ to catch the @0@;\n" +
//                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
            "\n" +
                    "There was an old lady who swallowed a @3@;\n" +
                    "Fancy that to swallow a @3@!\n" +
                    "She swallowed the @3@ to catch the @2@,\n" +
                    "She swallowed the @2@ to catch the @1@,\n" +
                    "She swallowed the @1@ to catch the @0@;\n" +
                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a @4@;\n" +
                    "What a hog, to swallow a @4@!\n" +
                    "She swallowed the @4@ to catch the @3@,\n" +
                    "She swallowed the @3@ to catch the @2@,\n" +
                    "She swallowed the @2@ to catch the @1@,\n" +
                    "She swallowed the @1@ to catch the @0@;\n" +
                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a @5@;\n" +
                    "I don't know how she swallowed a @5@!\n" +
                    "She swallowed the @5@ to catch the @4@,\n" +
                    "She swallowed the @4@ to catch the @3@,\n" +
                    "She swallowed the @3@ to catch the @2@,\n" +
                    "She swallowed the @2@ to catch the @1@,\n" +
                    "She swallowed the @1@ to catch the @0@;\n" +
                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
                    "\n";

    private Theme theme;

    public Song() {
        this.theme = new FarmTheme();
    }

    public Song(Theme theme) {
        this.theme = theme;
    }

    public String playSong() {
        return playSong(theme.getAnimals());
    }

    private String playSong(List<String> animals) {
        String song = addFirstStrophe(animals.get(0));
        song += addMiddleStrophes(animals);
        song += addLastStrophe(animals.get(animals.size() - 1));
        return song;
    }

    private String addFirstStrophe(String animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal);

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(firstStropheTemplate);
    }

    private String addMiddleStrophes(List<String> animals) {

        String second = addSecondStrophe(animals.get(0), animals.get(1));
        second += addThirdStrophe(animals.get(0), animals.get(1), animals.get(2));

        String middle = songTemplate;
        for (int i = 0; i < animals.size() - 1; i++) {
            middle = middle.replaceAll("@" + i + "@", animals.get(i));
        }
        return second + middle;
    }

    private String addSecondStrophe(String animal0, String animal1) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal1};\n" +
                "That wriggled and wiggled and tickled inside her.\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animal0);
        values.put("animal1", animal1);

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addThirdStrophe(String animal0, String animal1, String animal2) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal2};\n" +
                "How absurd to swallow a ${animal2}.\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animal0);
        values.put("animal1", animal1);
        values.put("animal2", animal2);

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addLastStrophe(String animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal);

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(lastStropheTemplate);
    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.playSong());
    }
}