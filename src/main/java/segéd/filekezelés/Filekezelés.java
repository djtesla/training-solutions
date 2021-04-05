package segéd.filekezelés;

import interfaces.HasName;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Filekezelés {


    public void readWithReaderFileUniversal(Reader reader) {
        try {
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    public static void main(String[] args) {
        try (FileReader fr = new FileReader(new File("names.txt"))) {
            new Filekezelés().readWithReaderFileUniversal(fr);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }


        try (InputStreamReader ir = new InputStreamReader(Filekezelés.class.getResourceAsStream("/employees.txt"))) {
            new Filekezelés().readWithReaderFileUniversal(ir);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }

        String names = "Géza, Muci, Árpi";
        StringReader sr = new StringReader(names);
        new Filekezelés().readWithReaderFileUniversal(sr);


    }


    public void writeWithBufferedWriterUniversal(BufferedWriter bw, List<String> names) {
        try {
            for (String name : names) {
                bw.write(name + '\n');
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    public static void writeWithBufferedWriterUniversalTest() {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("names.txt"))) {
            new Filekezelés().writeWithBufferedWriterUniversal(bw, Arrays.asList("Gézu", "Joc", "Mari"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load/create file", ioe);
        }

        StringWriter sw = new StringWriter();
        try (BufferedWriter bw = new BufferedWriter(sw)) {
            new Filekezelés().writeWithBufferedWriterUniversal(bw, Arrays.asList("Gézu", "Joc", "Mari"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load/create file", ioe);
        }
        System.out.println(sw.toString());
    }



    public void readFromClassPathToStringList(String file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Filekezelés.class.getResourceAsStream("/" + file)))) {
            List<String> lineData = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lineData.add(line);
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }


    public void readBytesOfJavaString() throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = Files.readAllBytes(Path.of("secret.dat"));
        for (byte b : bytes) {
            char c = (char) (b + 10);
            sb.append(c);
        }
        System.out.println(sb.toString());
    }


    // 1.	Egybe / olvasás-írás / karakteres adat, sima Stirng és Stirng lista
//The method ensures that the file is closed when all content have been read or an I/O error;
// nem implementálja ezért az autoClosable és nem lehet TWR se mert nem kell
    public void readAndWriteEgybeText() {
        String name;
        try {
            name = Files.readString(Path.of("names.txt"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        List<String> names;
        try {
            names = Files.readAllLines(Path.of("names.txt"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        name = "Géza";
        try {
            Files.writeString(Path.of("names.txt"), name, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        names = List.of("Géza", "Muci", "Piri");
        try {
            Files.write(Path.of("names.txt"), names, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    //Egybe/olvasás-írás/Byteos adat
    public void readAndWriteEgybeByte() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of("secret.dat"));
            System.out.println(Arrays.toString(bytes));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        try {
            Files.write(Path.of("newdat.dat"), new byte[]{97, 98, 99, 100});
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    //Darabokba/OLvasás-írás/karakteres adat
//TWR!, Reader és Writer
    public void readAndWriteDarabokbaText() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("names.txt"), StandardOpenOption.APPEND)) {
            List<String> names = List.of("Béci", "Janci", "Manci");
            for (String name : names) {
                writer.write('\n' + name);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void writeDarabokbaTextbeMásAdat() {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of("names.txt"), StandardOpenOption.APPEND))) {
            List<String> names = List.of("Béci", "Janci", "Manci");
            for (String name : names) {
                writer.print('\n' + name);
                writer.print(", salary: ");
                writer.print(1000);
                writer.print(true);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }


    public void stringWriter() {
        StringWriter sw = new StringWriter();
        try (BufferedWriter bufferedWriter = new BufferedWriter(sw)) {
            sw.write(Files.readString(Path.of("names.txt")));
            System.out.println(sw.toString());
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    //Darabokba/OLvasás-írás/byte állomány - stream, TWR
    public void readAndWriteDarabokbaByte() {
        try (BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(Path.of("data.dat")))) {
            byte[] bytes = new byte[1000]; //puffer
            int size;
            while ((size = inputStream.read(bytes)) == 1000) {
                StringBuilder str = new StringBuilder();
                /*for (int i =0; i <bytes.length; i++) {
                  str.append((bytes[i]));
                  System.out.println(str.toString());*/
            }
            System.out.println(size);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        try (BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Path.of("newdata.dat")))) {
            for (int i = 0; i < 1000; i++) {
                outputStream.write("abcd".getBytes());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    //Darabokba/OLvasás-írás/byte állomány/más adat - datastream, TWR
    public void readAndWriteDarabokbaByteMásadat() {
        try (DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(Path.of("newdata.dat"))))) {

            outputStream.writeUTF("Joci");
            outputStream.writeDouble(100.5);
            outputStream.writeBoolean(true);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(Path.of("newdata.dat"))))) {

            System.out.println(inputStream.readUTF());
            System.out.println(inputStream.readDouble());
            System.out.println(inputStream.readBoolean());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    //Darabokba/Írás/byte állomány/más adat - PrintStream
    public void writePrintStreamDarabokbaByteMásAdat() {
        try (PrintStream outputStream = new PrintStream(new BufferedOutputStream(Files.newOutputStream(Path.of("newdata.dat"))))) {
            outputStream.print("Jocika");
            outputStream.print(150.5);
            outputStream.print(false);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }


    //Darabokba/Írás/byte állomány/tömörítéssel - ZipOutputStream
    public void writeDarabokbaStremZip() {
        try (ZipOutputStream outputStream = new ZipOutputStream(
                new BufferedOutputStream(Files.newOutputStream(Path.of("newdata.zip"))))) {
            outputStream.putNextEntry(new ZipEntry("newdata.dat"));
            outputStream.write("abcd".getBytes());
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


}





