package postcoursegyak.ourworldindata.operations;

import org.mariadb.jdbc.MariaDbDataSource;
import postcoursegyak.ourworldindata.dao.OurWorldInDataDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataOperations {

    private OurWorldInDataDao ourWorldInDataDao;


    public DataOperations(OurWorldInDataDao ourWorldInDataDao) {
        this.ourWorldInDataDao = ourWorldInDataDao;
    }

    public List<DailyEntry> readFile(BufferedReader reader) {
        int count = 0;

        List<DailyEntry> entries = new ArrayList<>();
        String line;

        try {
            readHeader(reader);
            while ((line = reader.readLine()) != null) {
                count++;
                Optional<DailyEntry> entry = getDailyEntryPerLine(line);
                if (entry.isPresent()) {
                    entries.add(entry.get());
                }
            }
            return entries;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);

        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage() + '\n' + "sor: " + count);

        }
    }



    private Optional<DailyEntry> getDailyEntryPerLine(String line) {
        String[] lineData = line.split(",");

        if (lineData[0].startsWith("OWID")) {
            return Optional.empty();

        }
        String continent = lineData[1];
        String location = lineData[2];
        LocalDate date = LocalDate.parse(lineData[3]);

        int totalCases = 0;
        int newCases = 0;
        int totalDeaths = 0;
        int newDeaths = 0;
        int icuPatients = 0;
        int hospPatients = 0;
        int peopleVaccinated = 0;
        int peopleFullyVaccinated = 0;
        int newVaccinations = 0;
        int population = 0;


        if (!lineData[4].isBlank()) {
            totalCases = (int) Double.parseDouble(lineData[4]);
        }
        if (!lineData[5].isBlank()) {
            newCases = (int)Double.parseDouble(lineData[5]);
        }
        if (!lineData[7].isBlank()) {
            totalDeaths = (int)Double.parseDouble(lineData[7]);
        }
        if (!lineData[8].isBlank()) {
            newDeaths = (int)Double.parseDouble(lineData[8]);
        }
        if (!lineData[17].isBlank()) {
            icuPatients = (int)Double.parseDouble(lineData[17]);
        }
        if (!lineData[19].isBlank()) {
            hospPatients = (int)Double.parseDouble(lineData[19]);
        }
        if (!lineData[35].isBlank()) {
            peopleVaccinated = (int)Double.parseDouble(lineData[35]);
        }
        if (!lineData[36].isBlank()) {
            peopleFullyVaccinated = (int)Double.parseDouble(lineData[36]);
        }
        if (!lineData[37].isBlank()) {
            newVaccinations = (int)Double.parseDouble(lineData[37]);
        }
        if (!lineData[44].isBlank()) {
            population = (int)Double.parseDouble(lineData[44]);
        }

        return Optional.of(new DailyEntry(continent, location, date, totalCases, newCases, totalDeaths, newCases, icuPatients, hospPatients, peopleVaccinated, peopleFullyVaccinated, newVaccinations, population));
    }


    private void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }


    public static void main(String[] args) throws IOException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/ourworldindatacovid?useUnicode=true");
            dataSource.setUser("ourworldindatacovid");
            dataSource.setPassword("ourworldindatacovid");
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot connect", sqe);
        }
        DataOperations dataOperations = new DataOperations(new OurWorldInDataDao(dataSource));
        BufferedReader reader = Files.newBufferedReader(Path.of("owid-covid-data.csv"));

        dataOperations.start(reader);






    }

    public void start(BufferedReader reader) {
        List<DailyEntry> entries = readFile(reader);
        System.out.println(entries.size());
        ourWorldInDataDao.uploadEntries(entries);


    }


}



