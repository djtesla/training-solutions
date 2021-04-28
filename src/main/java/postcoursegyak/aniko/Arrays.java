package postcoursegyak.aniko;

import java.util.*;

public class Arrays {

    public int lastIndexOf(int[] numbers, int number) {
        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                selected.add(i);
            }
        }
        return selected.get(selected.size() - 1);
    }


    public int range(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min = getActualMin(numbers[i], min);
            max = getActualMax(numbers[i], max);
        }
        return Math.abs(min - max) + 1;
    }

    private int getActualMax(int number, int max) {
        if (number > max) {
            return number;
        }
        return max;
    }


    private int getActualMin(int number, int min) {
        if (number < min) {
            return number;
        }
        return min;
    }

    public int countInRange(int[] numbers, int min, int max) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (checkIfIsBetweenMinAndMax(numbers[i], min, max)) {
                count++;
            }
        }
        return count;
    }


    private boolean checkIfIsBetweenMinAndMax(int number, int min, int max) {
        return number > min && number < max;
    }

    public static boolean isSorted(double[] numbers) {

        double[] numbersSorted = new double[numbers.length];
        System.arraycopy(numbers, 0, numbersSorted, 0, numbers.length);
        java.util.Arrays.sort(numbersSorted);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != numbersSorted[i]) {
                return false;
            }
        }
        return true;
    }

    public int mode(int[] numbers) {
        Map<Integer, Integer> numbersWithOccurrences = new HashMap<>();
        int maxOccurrence = 0;
        int occurrence = 0;
        int numberWithMostOccurrence = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (!numbersWithOccurrences.containsKey(numbers[i])) {
                numbersWithOccurrences.put(numbers[i], 0);
            }
            occurrence = numbersWithOccurrences.get(numbers[i]) + 1;
            numbersWithOccurrences.put(numbers[i], occurrence);
            if (occurrence > maxOccurrence) {
                maxOccurrence = occurrence;
                numberWithMostOccurrence = numbers[i];
            }
        }
        return numberWithMostOccurrence;
    }





    public static void main(String[] args) {
        //System.out.println(new Arrays().lastIndexOf(new int[]{74, 85, 102, 99, 101, 85, 56}, 85));
        //System.out.println(new Arrays().range(new int[]{15, 10, 6, 7, 4, 11,13,14}));
        //System.out.println(new Arrays().countInRange(new int[]{14, 1, 22, 17, 36, 7, -43, 5},4, 17));
        System.out.println(isSorted(new double[]{1.5, 4.3, 4.3, 7.0, 19.5, 25.1, 46.2}));
        System.out.println(new Arrays().mode(new int[]{11, 27, 15, 15, 11, 27, 11}));


    }

}
