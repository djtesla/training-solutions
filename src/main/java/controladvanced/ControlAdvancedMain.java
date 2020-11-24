package controladvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlAdvancedMain {


    public static List<Integer> findDuplicates (List<Integer> numbers ) {

        int i = 1;

        List<Integer> duplicates = new ArrayList<>();


        for (int n : numbers) {
            for (int j = i; j < numbers.size(); j++) {
                if (n == numbers.get(j) && ! duplicates.contains(n)) {
                    duplicates.add(n);
                    break;
                }
            }
            i++;
        }
        return duplicates;
    }


    public static List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();

        for (String line: lines) {
            String[] parts = line.split(";");

            if(parts.length != 4) {
                continue;
            }

            if (parts[0].length() == 7 && parts[0].contains("-") &&
                    (Integer.parseInt(parts[1]) > 1970 && Integer.parseInt(parts[1]) < 2019 )){
                validLines.add(line);
            }
        }

        return validLines;
    }




    public static void main(String[] args) {
       List<Integer> duplicates = findDuplicates(Arrays.asList(3,1,2,3,4,5,3,8,6,7,8));
        System.out.println(duplicates);


        List<String> filteredLines = filterLines(Arrays.asList("ABC-123;2007;Volvo;red", "AB-123;2007;Volvo;red", "YES-111;2010;Toyota;black", "ABC-123;1965;Volvo;red"));
        System.out.println(filteredLines);

    }
}
