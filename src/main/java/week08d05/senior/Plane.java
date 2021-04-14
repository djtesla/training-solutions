package week08d05.senior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Plane {

    public int getLongestRideOverOcean(String fileName) {
        try (Scanner scanner = new Scanner(Path.of(fileName)).useDelimiter("1")) {
            int lMax = 0;
            while (scanner.hasNext()) {
                int l = scanner.next().length();
                if (lMax < l) {
                    lMax = l;
                }
            }
            return lMax;
        } catch(IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Plane().getLongestRideOverOcean("map.txt"));

    }
}
