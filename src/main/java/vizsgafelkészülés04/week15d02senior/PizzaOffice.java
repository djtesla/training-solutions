package vizsgafelkészülés04.week15d02senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PizzaOffice {

    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");




    public List<OrderReportPerDate> readFileToList(BufferedReader reader) throws IOException {
        List<OrderReportPerDate> reports = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            LocalDate dateOfOrders = LocalDate.parse(line, FORMATTER);
            OrderReportPerDate report = new OrderReportPerDate(dateOfOrders);
            line = addOrdersToReport(reader, report);
            reports.add(report);
        }
        return reports;
    }


    private String addOrdersToReport(BufferedReader reader, OrderReportPerDate report) throws IOException {
        String line = null;
        try {
            while (!checkIfLineIsDate(line = reader.readLine())) {
                PizzaOrder order = getOrderData(reader, line);
                report.addPizzaOrder(order);
            }
        } catch (NullPointerException npe) {
            return line;
        }
        return line;
    }



    private PizzaOrder getOrderData(BufferedReader reader, String line) throws IOException {
        String buddyName = line;
        String[] lineData = reader.readLine().split(" ");
        String address = String.join(" ", lineData[0], lineData[1], lineData[2]);
        LocalTime timeOfOrder = LocalTime.parse(lineData[3]);
        return new PizzaOrder(buddyName, address, timeOfOrder);
    }


    private boolean checkIfLineIsDate(String line) {

        try {
            LocalDate.parse(line, FORMATTER);
            return true;
        } catch (DateTimeException dte) {
            return false;
        }
    }



    public OrderReportPerDate getDateWithFewestOrders(BufferedReader reader) throws  IOException {
        List<OrderReportPerDate> reports = readFileToList(reader);
        System.out.println(reports);
        OrderReportPerDate reportWithFewestOrders = null;
        int min = Integer.MAX_VALUE;
        for (OrderReportPerDate orderReportPerDate : reports) {
            int ordersByFocused = orderReportPerDate.getPizzaOrders().size();
            if (ordersByFocused < min) {
                min = ordersByFocused;
                reportWithFewestOrders = orderReportPerDate;
            }
        }
        return reportWithFewestOrders;
    }


    public Map<String,Integer> statistics(BufferedReader reader) throws  IOException {
        Map<String, Integer> statMap = new TreeMap<>();
        List<OrderReportPerDate> reports = readFileToList(reader);
        for (OrderReportPerDate report : reports) {
            loadMapByReports(statMap, report);
        }
        return statMap;
    }

    private void loadMapByReports(Map<String, Integer> statMap, OrderReportPerDate report) {
        for (PizzaOrder order: report.getPizzaOrders()) {
            String buddy = order.getBuddyName();
            if (!statMap.containsKey(buddy)) {
                statMap.put(buddy, 0);
            }
            statMap.put(buddy, statMap.get(buddy) + 1);
        }
    }

    public static void main(String[] args) {
        PizzaOffice po = new PizzaOffice();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/gyakorlás/orders.txt"))) {
            //System.out.println(po.readFileToList(reader));
            //System.out.println(po.getDateWithFewestOrders(reader));
            System.out.println(po.statistics(reader));

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }
}
