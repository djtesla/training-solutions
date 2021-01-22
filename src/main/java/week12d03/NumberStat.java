package week12d03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class NumberStat {

    private List<Integer> numbers;


    public int getSmallestNumberWithOneOccurrence() {

        Path path = Path.of("numbers.txt");
        numbers = readNumbersFromFile(path);
        Collections.sort(numbers);
        int focused = numbers.get(0);
        int counter = 0;

        for (int actual : numbers) {
            if (focused == actual) {
                counter++;
            } else {
                if (counter == 1) {
                    return focused;
                }
                counter = 1;
                focused = actual;
            }
        }

        if (counter == 1) {
            return(numbers.get(numbers.size() - 1));
        }

        throw new IllegalArgumentException("There is no number with one occurrence!");
    }



    public List<Integer> readNumbersFromFile(Path path) {

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] lineElements = line.split(",");

                for (String lineElement : lineElements) {
                    numbers.add(Integer.parseInt(lineElement));
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        return numbers;
    }

}


/*
    Mai Junior/Mid-level feladat:
        Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló listát.
        Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet! Ellenőrizd,
        hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
        pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
        Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma. A fent megírt metódus ezen a listán dolgozzon.
        A lista elemeit fájlból töltsük fel. A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:
        1,1,4
        2,3,5
        2,2,5
*/
