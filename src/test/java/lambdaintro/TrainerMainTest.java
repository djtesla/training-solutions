package lambdaintro;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class TrainerMainTest {

    @Test
    public void findFirstTest() {
      assertEquals("Béci",new TrainerMain().findfirst(List.of(new Trainer("Béci", 7),
              new Trainer("Lajos", 5)), trainer -> trainer.getName().equals("Béci")));

    }
}