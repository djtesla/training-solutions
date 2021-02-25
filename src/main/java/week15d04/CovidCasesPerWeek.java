package week15d04;

import java.util.Iterator;

public class CovidCasesPerWeek implements Comparable<CovidCasesPerWeek> {

    private int week;
    private int cases;

    public CovidCasesPerWeek(int week, int cases) {
        this.week = week;
        this.cases = cases;
    }

    public int getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public int compareTo(CovidCasesPerWeek o) {
        return cases - o.cases;
    }

    @Override
    public String toString() {
        return "week=" + week + ", cases=" + cases;


    }
}
