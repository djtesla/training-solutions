package stringscanner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {

        int sum = 0;
        try (Scanner scanner = new Scanner(intString)) {

            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }


            while (scanner.hasNext()) {
                if (delimiter.isEmpty() || !scanner.hasNextInt()) {
                    throw new IllegalArgumentException("Incorrect parameter string!");
                }
                sum += scanner.nextInt();
            }
        }catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
            }

        return sum;
        }





    public boolean isEmpty (String input) {
        return ( input == null || "".equals(input.trim()));
    }





    public int readAndSumValues(String intString) {

        Scanner scanner = new Scanner(intString);

        int sum = 0;
        while (scanner.hasNext()) {
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Incorrect parameter string!");
            }
            sum +=scanner.nextInt();
        }
        return sum;




    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        String lines = "";
        try (Scanner scanner = new Scanner(Path.of("szöveg.txt"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(word)) {
                    lines += line + "\n";
                }
            }
        }  catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return lines;
    }




    public static void main(String[] args) {

        String lines = "";

        try (Scanner scanner = new Scanner(Path.of("szöveg.txt"))) {
            while (scanner.hasNextLine()) {
               lines += scanner.nextLine() + "\n";
                }
        }  catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        System.out.println(new StringScanner().readAndSumValues("1,2,3,4,5", ","));

        System.out.println(new StringScanner().filterLinesWithWordOccurrences(lines, "parádé"));




        }




    }

