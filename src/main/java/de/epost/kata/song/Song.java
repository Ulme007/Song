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


//    private String songTemplate =
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
//            "\n" +
//                    "There was an old lady who swallowed a @3@;\n" +
//                    "Fancy that to swallow a @3@!\n" +
//                    "She swallowed the @3@ to catch the @2@,\n" +
//                    "She swallowed the @2@ to catch the @1@,\n" +
//                    "She swallowed the @1@ to catch the @0@;\n" +
//                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
//                    "\n" +
//                    "There was an old lady who swallowed a @4@;\n" +
//                    "What a hog, to swallow a @4@!\n" +
//                    "She swallowed the @4@ to catch the @3@,\n" +
//                    "She swallowed the @3@ to catch the @2@,\n" +
//                    "She swallowed the @2@ to catch the @1@,\n" +
//                    "She swallowed the @1@ to catch the @0@;\n" +
//                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
//            "\n" +
//                    "There was an old lady who swallowed a @5@;\n" +
//                    "I don't know how she swallowed a @5@!\n" +
//                    "She swallowed the @5@ to catch the @4@,\n" +
//                    "She swallowed the @4@ to catch the @3@,\n" +
//                    "She swallowed the @3@ to catch the @2@,\n" +
//                    "She swallowed the @2@ to catch the @1@,\n" +
//                    "She swallowed the @1@ to catch the @0@;\n" +
//                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
//                    "\n";

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
        String middleSong = addSecondStrophe(animals);
        middleSong += addThirdStrophe(animals);
        middleSong += addFourthStrophe(animals);
        middleSong += addFifthStrophe(animals);
        middleSong += addSixthStrophe(animals);
        middleSong += "\n";

        return middleSong;
    }

    private String addSecondStrophe(List<String> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal1};\n" +
                "That wriggled and wiggled and tickled inside her.\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0));
        values.put("animal1", animals.get(1));

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addThirdStrophe(List<String> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal2};\n" +
                "How absurd to swallow a ${animal2}.\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0));
        values.put("animal1", animals.get(1));
        values.put("animal2", animals.get(2));

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addFourthStrophe(List<String> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal3};\n" +
                "Fancy that to swallow a ${animal3}!\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0));
        values.put("animal1", animals.get(1));
        values.put("animal2", animals.get(2));
        values.put("animal3", animals.get(3));

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addFifthStrophe(List<String> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal4};\n" +
                "What a hog, to swallow a ${animal4}!\n" +
                "She swallowed the ${animal4} to catch the ${animal3},\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0));
        values.put("animal1", animals.get(1));
        values.put("animal2", animals.get(2));
        values.put("animal3", animals.get(3));
        values.put("animal4", animals.get(4));

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addSixthStrophe(List<String> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal5};\n" +
                "I don't know how she swallowed a ${animal5}!\n" +
                "She swallowed the ${animal5} to catch the ${animal4},\n" +
                "She swallowed the ${animal4} to catch the ${animal3},\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0));
        values.put("animal1", animals.get(1));
        values.put("animal2", animals.get(2));
        values.put("animal3", animals.get(3));
        values.put("animal4", animals.get(4));
        values.put("animal5", animals.get(5));

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