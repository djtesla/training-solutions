package week14d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {


    @Test
    public void indexTest () {

        System.out.println(new Indexer().index(List.of("Béci", "Joci", "Gézu",
                "Babu", "Gaben", "Icu", "Sámson", "Bendi", "Karesz", "Sanyi", "Icu")));
    }

}