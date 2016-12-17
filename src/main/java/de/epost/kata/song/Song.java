package de.epost.kata.song;

import de.epost.kata.song.Theme.Animal;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Song {

    private static final String firstStropheTemplate =
            "There was an old lady who swallowed a ${animal}.\n" +
                    "I don't know why she swallowed a ${animal} - perhaps she'll die!\n";

    private static final String lastStropheTemplate =
            "There was an old lady who swallowed a ${animal}...\n" +
                    "...She's dead, of course!";


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
        return sub.replace(firstStropheTemplate);
    }

    private String addMiddleStrophes(List<Animal> animals) {
        String middleSong = addSecondStrophe(animals);
        middleSong += addThirdStrophe(animals);
        middleSong += addFourthStrophe(animals);
        middleSong += addFifthStrophe(animals);
        middleSong += addSixthStrophe(animals);
        middleSong += "\n";

        return middleSong;
    }

    private String addSecondStrophe(List<Animal> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal1};\n" +
                "${animalRhyme1}\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animalRhyme1", animals.get(1).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addThirdStrophe(List<Animal> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal2};\n" +
                "${animalRhyme2} ${animal2}.\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animal2", animals.get(2).getName());
        values.put("animalRhyme2", animals.get(2).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addFourthStrophe(List<Animal> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal3};\n" +
                "${animalRhyme3} ${animal3}!\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animal2", animals.get(2).getName());
        values.put("animal3", animals.get(3).getName());
        values.put("animalRhyme3", animals.get(3).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addFifthStrophe(List<Animal> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal4};\n" +
                "${animalRhyme4} ${animal4}!\n" +
                "She swallowed the ${animal4} to catch the ${animal3},\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animal2", animals.get(2).getName());
        values.put("animal3", animals.get(3).getName());
        values.put("animal4", animals.get(4).getName());
        values.put("animalRhyme4", animals.get(4).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addSixthStrophe(List<Animal> animals) {
        String strophe = "\n" +
                "There was an old lady who swallowed a ${animal5};\n" +
                "${animalRhyme5} ${animal5}!\n" +
                "She swallowed the ${animal5} to catch the ${animal4},\n" +
                "She swallowed the ${animal4} to catch the ${animal3},\n" +
                "She swallowed the ${animal3} to catch the ${animal2},\n" +
                "She swallowed the ${animal2} to catch the ${animal1},\n" +
                "She swallowed the ${animal1} to catch the ${animal0};\n" +
                "I don't know why she swallowed a ${animal0} - perhaps she'll die!\n";

        Map<String, String> values = new HashMap<>();
        values.put("animal0", animals.get(0).getName());
        values.put("animal1", animals.get(1).getName());
        values.put("animal2", animals.get(2).getName());
        values.put("animal3", animals.get(3).getName());
        values.put("animal4", animals.get(4).getName());
        values.put("animal5", animals.get(5).getName());
        values.put("animalRhyme5", animals.get(5).getRhyme());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(strophe);
    }

    private String addLastStrophe(Animal animal) {
        Map<String, String> values = new HashMap<>();
        values.put("animal", animal.getName());

        StrSubstitutor sub = new StrSubstitutor(values);
        return sub.replace(lastStropheTemplate);
    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.playSong());
    }
}