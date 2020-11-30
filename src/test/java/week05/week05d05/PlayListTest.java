package week05.week05d05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    PlayList playList =new PlayList(Arrays.asList(
            new Song("A hold dala",185,"Kozsó"),
                new Song("Crazy",175,"Britney Spears"),
                new Song("Évszakok",190,"Balás Fecó"),
                new Song("Keresem a lányt",182,"V.I.P."),
                new Song("Heand and heart",200,"Joe Cory")));
    @Test
    public void testFindByLengthGreaterThan () {
        assertEquals(3, playList.findByLengthGreaterThan(3).size());
    }

    @Test
    public void testToString () {
        System.out.println(playList.toString());
    }

}