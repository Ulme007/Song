package de.epost.kata.song;

import java.util.List;

class Song {

    private String song =
            "\n" +
                    "There was an old lady who swallowed a @1@;\n" +
                    "That wriggled and wiggled and tickled inside her.\n" +
                    "She swallowed the @1@ to catch the @0@;\n" +
                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a @2@;\n" +
                    "How absurd to swallow a @2@.\n" +
                    "She swallowed the @2@ to catch the @1@,\n" +
                    "She swallowed the @1@ to catch the @0@;\n" +
                    "I don't know why she swallowed a @0@ - perhaps she'll die!\n" +
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
        //this.song = buildSong(theme.getAnimals());
    }

    public Song(Theme theme) {
        this.theme = theme;
    }

    //    private String buildSong(List<String> animals) {
//        String song = "";
//        for (int i = 0; i < animals.size() - 1; i++) {
//            song += buildStrophe(animals.subList(0, i));
//        }
//        song += buildLastStrophe(animals.get(animals.size()-1));
//
//        return song;
    public String playSong() {
        return playSong(theme.getAnimals());
    }

    private String playSong(List<String> animals) {
        String firstStrophe = addFirstStrophe(animals.get(0));

        String middle = song;
        for (int i = 0; i < animals.size() - 1; i++) {
            middle = middle.replaceAll("@" + i + "@", animals.get(i));
        }

        firstStrophe += middle;
        firstStrophe += addLastStrophe(animals.get(animals.size() - 1));
        return firstStrophe;
    }

    private String addFirstStrophe(String animal) {
        return "There was an old lady who swallowed a " + animal + ".\n" +
                "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n";
    }

    private String addLastStrophe(String animal) {
        return "There was an old lady who swallowed a " + animal + "...\n" +
                "...She's dead, of course!";
    }


//    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.playSong());
    }
/*
    private String buildStrophe(List<String> animals, String secondLine) {
        String strophe = "There was an old lady who swallowed a " + animals.get(0) + ".\n";


        strophe += secondLine.replace("@animal@", animals.get(1));





        strophe +=
    }

    private String buildLastStrophe(String animal) {
        return "There was an old lady who swallowed a " + animal + "...\n" +
                "...She's dead, of course!";
    }
    */
}