package collectionsmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String SEPARATOR = ":";
    public static final int NUMBER_OF_ELEMENTS = 3;


    public Map<String, List<Entry>> parseLog(String log) {

        Map<String, List<Entry>> map = new HashMap<>();
        List<Entry> entries = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new StringReader(log))) {
            String line;
            while ((line = reader.readLine()) != null) {

                List<String> lineData = new ArrayList<>();
                Collections.addAll(lineData, line.split(SEPARATOR));
                if (lineData.size() != NUMBER_OF_ELEMENTS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }

                entries.add(getNewEntryList(lineData));
                map.put(lineData.get(0), entries);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read string");
        }
        return map;
    }




    private Entry getNewEntryList(List<String> lineData) {
        LocalDate date;
        String ip = lineData.get(0);
        try {
            date = LocalDate.parse(lineData.get(1), DATE_FORMAT);
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date", dtpe);
        }
        String login = lineData.get(2);

        return new Entry(ip, date, login);
    }


}

//String log = "176.121.45.124:2016-12-02:derzsi\n"
//      + "176.121.45.124:2016-12-03:ggrrrr\n";

//ip-date-login
