package methodvarargs.examstats;

public class ExamStats {

    private int maxPoints;

    public int getMaxPoints() {
        return maxPoints;
    }

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {

        if (isEmpty(results)) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        int i = 0;
        for (int result : results) {
            if ((double) result / maxPoints * 100 > limitInPercent) {
                i++;
            }
        }
        return i;
    }

    private boolean isEmpty(int[] results) {
        return results == null || results.length == 0;
    }


    public boolean hasAnyFailed (int limitInPercent, int...results) {
        int i = 0;

        if (isEmpty(results)) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        for (int result : results) {
            if ((double) result / maxPoints * 100 < limitInPercent) {
                return true;
            }
        }
        return false;

    }






}
