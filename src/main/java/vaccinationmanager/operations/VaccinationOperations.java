package vaccinationmanager.operations;

import org.mariadb.jdbc.MariaDbDataSource;
import vaccinationmanager.dao.VaccinationsDao;
import vaccinationmanager.userinterface.UserMenuMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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


        String name = null;
        while (name == null) {
            name = registerName();
        }

        String postalCode = null;
        while (postalCode == null) {
            postalCode = registerPostalCode();
            String city = vaccinationsDao.queryCity(postalCode);
            System.out.println("***" + city.toUpperCase() + "***");
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
        if (DATA_VALIDATION.isValidSocSecNumber(socSecNumber)) {
            return socSecNumber;
        }
        return null;
    }


    public void massRegister() {
        System.out.println("File feltöltéshez kérem adja meg az elérési útvonalat (elérési út/filenév.csv): ");

        String pathSTR = SCANNER.nextLine();
        Path path = Path.of(pathSTR);
        DATA_VALIDATION.checkIfExit(pathSTR);
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


    private void readHeader(BufferedReader reader) throws IOException {
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
        String postalCode = registerPostalCode();
        System.out.println(vaccinationsDao.queryCity(postalCode));
        String pathStr = null;
        while (pathStr == null) {
            pathStr = requestPath();
        }
        System.out.println(pathStr);

        List<Citizen> citizens = vaccinationsDao.queryCitizensTobeVaccinatedByPostalCode(postalCode);
        Collections.sort(citizens, new CitizenComparator());
        List<Citizen> citizensToBeVaccinatedPerPostalCodeTopList;
        if (citizens.size()> 15 ) {
            citizensToBeVaccinatedPerPostalCodeTopList = citizens.subList(0, 16);
        } else {
            citizensToBeVaccinatedPerPostalCodeTopList = citizens.subList(0, citizens.size()-1);
        }
        addTimeOfScheduledVaccination(citizensToBeVaccinatedPerPostalCodeTopList);
        System.out.println(citizensToBeVaccinatedPerPostalCodeTopList);
        Path path = Path.of(pathStr + "\\" + postalCode + ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writeFile(writer, citizensToBeVaccinatedPerPostalCodeTopList);
            System.out.println('\n' + "*****A FILE EL LETT MENTVE " + path.toString().toUpperCase() + " NÉVEN.*****");
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private String requestPath() {
        System.out.println("A file ide lesz elmentve: 'C:\\Oltások'. Felülírja? (I/N)");

        String input = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(input);
        if (input.equals("N")) {
            String folderStr = "C:\\Oltások";
            createDirIfNotExists(folderStr);
            return folderStr;

        } else if (input.equals("I")) {
            System.out.println("Kérjük adja meg az elérési útvonalat:");
            String folderStr = SCANNER.nextLine();
            createDirIfNotExists(folderStr);
            return folderStr;
        } else {

            return null;
        }
    }


    private void writeFile(BufferedWriter writer, List<Citizen> citizens) throws IOException {
        writeHeader(writer);
        for (Citizen citizen : citizens) {
            writer.write(getLineData(citizen));
        }
    }

    private void writeHeader(BufferedWriter writer) throws IOException {
        writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám" + '\n');
    }

    private String getLineData(Citizen citizen) {
        StringBuilder sb = new StringBuilder();
        sb.append(citizen.getScheduledVaccination());
        sb.append(";");
        sb.append(citizen.getName());
        sb.append(";");
        sb.append(citizen.getPostalCode());
        sb.append(";");
        sb.append(citizen.getAge());
        sb.append(";");
        sb.append(citizen.getEmail());
        sb.append(";");
        sb.append(citizen.getSocSecNumber());
        sb.append('\n');
        return sb.toString();
    }


    private void createDirIfNotExists(String folderStr) {
        try {
            if (!Files.exists(Path.of(folderStr))) {
                Files.createDirectory(Path.of(folderStr));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot create folder", ioe);
        }
    }


    private void addTimeOfScheduledVaccination(List<Citizen> citizensToBeVaccinatedPerPostalCodeTopList) {
        int count = -1;
        for (Citizen citizen : citizensToBeVaccinatedPerPostalCodeTopList) {
            count++;
            citizen.setScheduledVaccination(getScheduledLcd(count));
        }

    }

    private LocalTime getScheduledLcd(int count) {
        return LocalTime.of(8, 0).plusMinutes(count * 30);
    }

    public void vaccinate() {
        System.out.println("Kérjük adja meg a TAJ számot:");
        String socSecNumber = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(socSecNumber);
        if (!DATA_VALIDATION.isValidSocSecNumber(socSecNumber)) {
            System.out.println("A TAJ szám nem megfelelő.");
            throw new InvalidDataInputException();
        }

        VaccinationDataByCitizen vaccinationDataByCitizen =
                vaccinationsDao.queryVaccinationDataByCitizenBySocSecNumber(socSecNumber);

        //System.out.println(vaccinationDataByCitizen);

        if (vaccinationDataByCitizen.getNumberOfVaccinations() == 0) {
            vaccinateAtFirst(vaccinationDataByCitizen);
        } else if (vaccinationDataByCitizen.getNumberOfVaccinations() == 1) {
            vaccinateAtSecond(vaccinationDataByCitizen);
        } else {
            doNotVaccinate(vaccinationDataByCitizen);
        }


        //throw new ExitFromApplicationException();

    }


    private void vaccinateAtFirst(VaccinationDataByCitizen vaccinationDataByCitizen) {
        System.out.println('\n' + "***ELSŐ OLTÁS***");

        LocalDateTime vaccinationDate = null;
        while (vaccinationDate == null) {
            vaccinationDate = requestDateOfVaccination();
        }
        String vaccinesType = null;
        while (vaccinesType == null) {
            vaccinesType = requestVaccinesType();
        }

        vaccinationsDao.saveVaccination(Arrays.asList(new VaccinationDataByCitizen(vaccinationDataByCitizen.getId(),
                1, vaccinationDate, vaccinesType)));
        //throw new ExitFromApplicationException();

    }


    private void vaccinateAtSecond(VaccinationDataByCitizen vaccinationDataByCitizen) {
        System.out.println('\n' + "***MÁSODIK OLTÁS***");
        String vaccinesType = vaccinationsDao.queryFirstVaccinesType(vaccinationDataByCitizen.getId());
        System.out.println("Az oltás a(z) " + vaccinesType + " vakcinával fog történni!" + '\n');
        LocalDateTime vaccinationDate = null;
        while (vaccinationDate == null) {
            vaccinationDate = requestDateOfVaccination();
        }

        vaccinationsDao.saveVaccination(Arrays.asList(new VaccinationDataByCitizen(vaccinationDataByCitizen.getId(),
                2, vaccinationDate, vaccinesType)));
    }


    private LocalDateTime requestDateOfVaccination() {
        System.out.println("Kérjük adja meg az oltás dátumát:");
        String dateStr = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(dateStr);
        try {
            LocalDate date = LocalDate.parse(dateStr);
            return date.atTime(0, 0);
        } catch (DateTimeParseException dtpe) {
            // adjon vissza nullt, hogy majd bekérje újra az adatot
            return null;
        }


    }

    private String requestVaccinesType() {
        System.out.println("Kérjük adja meg az a vakcina típusát: (Biontech_Pfizer, Moderna, AstraZeneca, Sinopharm");
        String vaccinesType = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(vaccinesType);
        if (DATA_VALIDATION.isValidVaccinesType(vaccinesType)) {
            return vaccinesType;
        }
        System.out.println("Nem megfelelő típust adott meg!");
        return null;
    }


    private void doNotVaccinate(VaccinationDataByCitizen vaccinationDataByCitizen) {
        System.out.println("A megadott TAJ számhoz tartozó személyt már kétszer beoltották!");
    }


    public void cancelVaccinate() {
        String socSecNumber = null;
        while (socSecNumber == null) {
            socSecNumber = getSocSecNumber();
        }


        LocalDateTime timeOfSchedule = null;
        while (timeOfSchedule == null) {
            timeOfSchedule = getTimeOfSchedule();
        }
        String noteOfCancellation = getNoteOfCancellation();
        vaccinationsDao.saveCanceledVaccination(socSecNumber, timeOfSchedule, noteOfCancellation);
    }


    private String getSocSecNumber() {
        System.out.println("TAJ szám: ");
        String socSecNumber = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(socSecNumber);
        if (DATA_VALIDATION.isValidSocSecNumber(socSecNumber)) {
            try {
                vaccinationsDao.queryCitizenIdBySocSecNumber(socSecNumber);
            } catch (InvalidDataInputException iie) {
                System.out.println("Nem található a megadott TAJ számnak megfelelő regisztrált!");
                return null;
            }
            return socSecNumber;
        }
        return null;
    }


    private String getNoteOfCancellation() {
        System.out.println("Kérem adja meg a meghiúsúlás okát:");

        String noteOfCancellation = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(noteOfCancellation);
        return noteOfCancellation;
    }

    private LocalDateTime getTimeOfSchedule() {
        System.out.println("Mikor lett volna az oltás? (Formátum: éééé-hh-nn óó:pp)");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timeOfScheduleStr = SCANNER.nextLine();
        DATA_VALIDATION.checkIfExit(timeOfScheduleStr);
        try {
            return LocalDateTime.parse(timeOfScheduleStr, formatter);
        } catch (DateTimeParseException dpe) {
            System.out.println("Nem megfelelő adatbevitel Kérjük próbálkozzon újra!");
            return null;
        }
    }


    public void report() {
        String postalCode = null;
        while (postalCode == null)
            postalCode = registerPostalCode();
        List<VaccinationReport> vaccinationReports = vaccinationsDao.queryReport(postalCode);

        //System.out.println(vaccinationReports);
        System.out.println('\n' + "***********************************" + '\n' +
                vaccinationsDao.queryCity(postalCode).toUpperCase() + " - RIPORT" + '\n' +
                "Megkappták a második oltást: " + vaccinationReports.get(2).getNumberOfCitizens() + " fő;" + '\n' +
                "Megkappták az első oltást :" + vaccinationReports.get(1).getNumberOfCitizens() + " fő;" + '\n' +
                "Még nem kaptak oltást: " + vaccinationReports.get(0).getNumberOfCitizens() + " fő."+ '\n'+
                "***********************************" + '\n');
    }


    public static void main(String[] args) {
        new UserMenuMain().displayMenu();
    }
}
