package vizsgafelkészülés04.exam02senior.lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class LottoReader {

    private int[] hits = new int[90];


    public LottoReader(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                List<String> numberStrList = Arrays.asList(line.split(";")).subList(11, 16);
                modifyHits(numberStrList);


            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }


        //this.number = number;
    }

    private void modifyHits(List<String> numberStrList) {
        //System.out.println(numberStrList);
        for (String numberStr : numberStrList) {
            int number = Integer.parseInt(numberStr);
            hits[number-1] = hits[number-1] + 1;
        }
    }


    public int getNumber(int number) {
        return hits[number-1];
    }


    public static void main(String[] args) {
        InputStream inputStream = LottoReader.class.getResourceAsStream("otos.csv");
        new LottoReader(inputStream);
    }
}
