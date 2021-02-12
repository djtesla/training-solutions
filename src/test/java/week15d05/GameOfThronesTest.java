package week15d05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameOfThronesTest {


    @Test
    public void createBattleMapTest() {
        GameOfThrones gof = new GameOfThrones();
        Map.Entry<String, Integer> houseWithMostBattles = gof.getHouseWithMostBattles("battles.txt");

        assertEquals(houseWithMostBattles.getKey(), "Lannister");
        assertEquals(houseWithMostBattles.getValue(), 19);
    }
}