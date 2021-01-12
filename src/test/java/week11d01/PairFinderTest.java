package week11d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {


    @Test
    public void PairFinderTest () {

    PairFinder pf = new PairFinder();
        System.out.println(pf.findPairs( new int[] {1,2,3,4,2,6,2,8}));
    }


}