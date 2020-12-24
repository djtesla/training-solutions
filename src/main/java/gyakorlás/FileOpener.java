package gyakorlás;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOpener {




    public static void openFile ()  {


        try  (Scanner scanner = new Scanner(FileOpener.class.getResourceAsStream("/proba/books.csv"))) {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        //try {
            openFile();
       /* } catch (Exception ie) {
            System.out.println("Wrong file."+ ie.getMessage());*/


        //List<String> name = new ArrayList<>();

        String[] name;


        String people = "X, Z, Z";

        name = people.split(",");

        System.out.println(name[0]);


        }


    }

