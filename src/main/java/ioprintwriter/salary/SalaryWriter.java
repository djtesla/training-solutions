package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {


    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }


    public void writeNamesAndSalaries(Path file) {

        try (PrintWriter writer = new PrintWriter((Files.newBufferedWriter(file)))) {


            for (String name : names) {

                writer.print(name + ": ");
                writer.print(getSalaryAsPerName(name) + "\n");



            }


        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public int getSalaryAsPerName(String name) {

        if (name.contains("Dr")) {
            return 500000;
        }

        if (name.contains("Mr") || name.contains("Mrs")) {
            return 200000;
        }

        return 100000;
    }


}


/*
Fizetések
        Ebben a feladatban emberek fizetését kell meghatároznod titulus alapján.
        A SalaryWriter osztály konstruktorban kap egy név listát. A writeNamesAndSalaries(Path file)
        metódus kiírja a fájlba név: összeg formátumban. A fizetések a következő képpen alakulnak:

        Ha tartalmazza a név a "Dr" előtagot, akkor 500000
        Ha a "Mr" vagy "Mrs" előtagot akkor 200000
        Különben 100000
*/



