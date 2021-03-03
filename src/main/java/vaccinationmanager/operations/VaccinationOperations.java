package vaccinationmanager.operations;

import org.mariadb.jdbc.MariaDbDataSource;
import vaccinationmanager.dao.VaccinationsDao;
import vaccinationmanager.userinterface.DataValidation;
import vaccinationmanager.userinterface.ExitException;
import vaccinationmanager.userinterface.UserMenuMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VaccinationOperations {

    public static final MariaDbDataSource DATASOURCE;

    static {
        try {
            DATASOURCE = new MariaDbDataSource();
            DATASOURCE.setUrl("jdbc:mariadb://localhost:3306/vaccinationmanager?useUnicode=true");
            DATASOURCE.setUser("vaccinationmanager");
            DATASOURCE.setPassword("vaccinationmanager");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot create database", se);
        }
    }

    public static final DataValidation DATA_VALIDATION = new DataValidation();
    public static final Scanner SCANNER = new Scanner(System.in);

    VaccinationsDao vaccinationsDao = new VaccinationsDao(DATASOURCE);


    public void registerMain() {
        System.out.println("Kérjük adja meg az alábbi adatait!" + '\n' + '\n');

        try {
            String name = null;
            while (name == null) {
                name = registerName();
            }

            String postalCode = null;
            while (postalCode == null) {
                postalCode = registerPostalCode();
                String city = vaccinationsDao.queryCity(postalCode);
                System.out.println(city);
            }

            int age = 0;
            while (age == 0) {
                age = registerAge();
            }

            String email = null;
            while (email == null) {
                email = registerEmail();
            }

            String socSecNumber = null;
            while (socSecNumber == null) {
                socSecNumber = registerSocSecNumber();
            }

            vaccinationsDao.saveCitizen(Arrays.asList(new Citizen(name, postalCode, age, email, socSecNumber)));


        } catch (ExitException ee) {
            System.out.println(ee.getMessage());
        }
    }


    private String registerName() {
        System.out.println("Teljes név: ");
        String name = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(name);
        if (DATA_VALIDATION.isValidName(name)) {
            return name;
        }
        return null;
    }


    private String registerPostalCode() {
        System.out.println("Irányítószám: ");
        String postalCode = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(postalCode);
        if (DATA_VALIDATION.isValidPostalCode(postalCode)) {
            return postalCode;
        }
        return null;
    }


    private int registerAge() {
        System.out.println("Életkor: ");
        String ageStr = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(ageStr);
        if (DATA_VALIDATION.isValidAge(ageStr)) {
            return Integer.parseInt(ageStr);
        }
        return 0;
    }


    private String registerEmail() {
        System.out.println("E-mail cím: ");
        String email = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(email);
        if (DATA_VALIDATION.isValidEmail(email)) {
            String second = repeatEmail(email);
            if (second != null) {
            }
            return second;
        }
        return null;
    }


    private String repeatEmail(String firstInput) {
        System.out.println("E-mail cím megismétlése: ");
        String email = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(email);
        if (DATA_VALIDATION.isValidSecondEmail(firstInput, email)) {
            return email;
        }
        return null;
    }


    private String registerSocSecNumber() {
        System.out.println("TAJ szám: ");
        String socSecNumber = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(socSecNumber);
        if (DATA_VALIDATION.isValidPostalCode(socSecNumber)) {
            return socSecNumber;
        }
        return null;
    }


    public void massRegister() {
        System.out.println("File feltöltéshez kérem adja meg az elérési útvonalat (elérési út/filenév.csv): ");
        Path path = Path.of(SCANNER.nextLine());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<Citizen> citizensTobeUploaded = readCitizensFromFile(reader);
            vaccinationsDao.saveCitizen(citizensTobeUploaded);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file, ioe");
        }
    }


    private List<Citizen> readCitizensFromFile(BufferedReader reader) throws IOException {
        readHeader(reader);
        List<Citizen> citizens = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Citizen citizen = getCitizenByLine(line);
            citizens.add(citizen);
        }
        return citizens;
    }


    private void readHeader(BufferedReader reader) throws  IOException {
        reader.readLine();
    }


    private Citizen getCitizenByLine(String line) {

        try {
            String[] lineData = line.split(";");
            String name = lineData[0];
            String postalCode = lineData[1];
            int age = Integer.parseInt(lineData[2]);
            String email = lineData[3];
            String socSecNumber = lineData[4].replace("\"", "");
            return new Citizen(name, postalCode, age, email, socSecNumber);

        } catch (Exception e) {
            throw new FileProcessingException("Error by processing file at line: " + line, e);
        }

    }


    public void generate() {
    }

    public void vaccinate() {
    }

    public void cancelVaccinate() {
    }

    public void report() {
    }


    public static void main(String[] args) {
        new UserMenuMain().displayMenu();
    }
}
