package de.epost.kata.song;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SongTest {

    public static final String DEFAULT_SONG =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a spider;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a bird;\n" +
            "How absurd to swallow a bird.\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cat;\n" +
            "Fancy that to swallow a cat!\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a dog;\n" +
            "What a hog, to swallow a dog!\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cow;\n" +
            "I don't know how she swallowed a cow!\n" +
            "She swallowed the cow to catch the dog,\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse...\n" +
            "...She's dead, of course!";

    private static final String FIND_NEMO_SONG =
            "There was an old lady who swallowed a Nemo.\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Dorie;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the Dorie to catch the Nemo;\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Marlin;\n" +
            "How absurd to swallow a Marlin.\n" +
            "She swallowed the Marlin to catch the Dorie,\n" +
            "She swallowed the Dorie to catch the Nemo;\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Cora;\n" +
            "Fancy that to swallow a Cora!\n" +
            "She swallowed the Cora to catch the Marlin,\n" +
            "She swallowed the Marlin to catch the Dorie,\n" +
            "She swallowed the Dorie to catch the Nemo;\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Rochen;\n" +
            "What a hog, to swallow a Rochen!\n" +
            "She swallowed the Rochen to catch the Cora,\n" +
            "She swallowed the Cora to catch the Marlin,\n" +
            "She swallowed the Marlin to catch the Dorie,\n" +
            "She swallowed the Dorie to catch the Nemo;\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Bruce;\n" +
            "I don't know how she swallowed a Bruce!\n" +
            "She swallowed the Bruce to catch the Rochen,\n" +
            "She swallowed the Rochen to catch the Cora,\n" +
            "She swallowed the Cora to catch the Marlin,\n" +
            "She swallowed the Marlin to catch the Dorie,\n" +
            "She swallowed the Dorie to catch the Nemo;\n" +
            "I don't know why she swallowed a Nemo - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Khan...\n" +
            "...She's dead, of course!";
    private static final String BREMER_TOWN_MUSICIANS_SONG = "There was an old lady who swallowed a Donkey.\n" +
            "I don't know why she swallowed a Donkey - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Dog;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the Dog to catch the Donkey;\n" +
            "I don't know why she swallowed a Donkey - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Cat;\n" +
            "How absurd to swallow a Cat.\n" +
            "She swallowed the Cat to catch the Dog,\n" +
            "She swallowed the Dog to catch the Donkey;\n" +
            "I don't know why she swallowed a Donkey - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a Cock...\n" +
            "...She's dead, of course!";

    @Test
    public void testDefaultSong() throws Exception {

        Song song = new Song();

        assertEquals(DEFAULT_SONG, song.playSong());
    }

    @Test
    public void playFarmSong() throws Exception {
        Song song = new Song(new FarmTheme());

        assertEquals(DEFAULT_SONG, song.playSong());
    }

    @Test
    public void playFindNemoSong() throws Exception {
        Song song = new Song(new FindNemoTheme());

        assertEquals(FIND_NEMO_SONG, song.playSong());
    }

    @Test
    public void playBremerTownMusicians() throws Exception {
        Song song = new Song(new BremerTownMusiciansTheme());

        assertEquals(BREMER_TOWN_MUSICIANS_SONG, song.playSong());
    }
}