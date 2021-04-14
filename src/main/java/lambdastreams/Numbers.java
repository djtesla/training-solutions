package lambdastreams;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {

    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream().reduce(0, (n, i) -> n + i);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(i -> i > 0);
    }


    public int min() {
        Optional<Integer> min =  numbers.stream().min(Comparator.naturalOrder());
        return min.get();
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().distinct().collect(Collectors.toSet());
    }


    public static void main(String[] args) {

        Numbers numbers = new Numbers(Arrays.asList(33,11,-22,33,4,5,4));
        //System.out.println(numbers.min());
        System.out.println(numbers.sum());
        System.out.println(numbers.isAllPositive());
        System.out.println(numbers.getDistinctElements());


    }
}
