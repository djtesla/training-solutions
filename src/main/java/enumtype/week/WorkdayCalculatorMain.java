package enumtype.week;

public class WorkdayCalculatorMain {

    public static void main(String[] args) {

        WorkdayCalculator workdayCalculator = new WorkdayCalculator();

        System.out.println(workdayCalculator.dayTypes(Day.WEDNESDAY, 3));
    }
}
