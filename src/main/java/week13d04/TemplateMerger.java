package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {


    public String merge(Path file, List<Employee> employees) {
        String templateLine;
        try {
            templateLine = Files.readString(file);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return createString(templateLine, employees);
    }



    public String createString(String templateLine, List<Employee> employees) {
            StringBuilder sb = new StringBuilder();
            for (Employee employee : employees) {
                String name = employee.getName();
                String year = Integer.toString(employee.getYearOfBirth());
                sb.append(templateLine.replace("{nev}", name).replace("{ev}", year));
                sb.append("\n");
            }
            return sb.toString();
        }

    }





/*    Mai junior feladat:
        Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
        metódust, ami felolvassa a fájlt, melynek tartalma:
        Az alkalmazott neve: {nev}, születési éve: {ev}
        Nyugodtan beolvashatod egy utasítással!
        Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
        mint ahogy a fájlban van, azaz:
        Az alkalmazott neve: John Doe, születési éve: 1980
        Az alkalmazott neve: Jack Doe, születési éve: 1990
        (Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.

        sablon!
        */

