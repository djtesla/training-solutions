package week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test

    public void stringListsUnionTest () {

        List<String> unifiedList  = new StringLists().stringListsUnion(Arrays.asList("a","b","c","d"), Arrays.asList("a","b","e"));

        System.out.println(unifiedList);
    }

}