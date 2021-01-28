package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    public void mergeTest() {
        TemplateMerger tm = new TemplateMerger();

        String output = tm.merge(Path.of("template.txt"), List.of(new Employee("Béci", 1980),
                new Employee("Béci", 1989)));


        System.out.println(output);


    }


}