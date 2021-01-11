package week10d05;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public int findMinSum(int[] arr) {

        List<Integer> sortedNumbers = new ArrayList<>();

        sortedNumbers.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            addNumberToSpecifiedIndex(sortedNumbers, arr[i]);
        }

        System.out.println(sortedNumbers);

        return getSumOfFirstFourElements(sortedNumbers);
    }


    public void addNumberToSpecifiedIndex(List<Integer> sortedNumbers, int arrElement) {

        for (int j = 0; j < sortedNumbers.size(); j++) {
            if (arrElement <= sortedNumbers.get(j)) {
                sortedNumbers.add(j, arrElement);
                return;
            }
        }
        sortedNumbers.add(arrElement);
    }


    public int getSumOfFirstFourElements(List<Integer> sortedNumbers) {

        int numberOfElementsToBeAdded = 0;

        if (sortedNumbers.size() < 4) {
            numberOfElementsToBeAdded = sortedNumbers.size();
        } else {
            numberOfElementsToBeAdded = 4;
        }

        int sum = 0;

        for (int j = 0; j < numberOfElementsToBeAdded; j++) {
            sum += sortedNumbers.get(j);
        }
        return sum;
    }

}





/*    Mai junior-mid-level feladat:
        Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa.
        A metódus feladata, hogy kiírja a legkisebb összegeket 4 számból, amiket lehetséges összerakni
        az arr tömb elemeiből. Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16.*/
