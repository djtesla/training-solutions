package methodparam.measuring;

public class Measurement {

    public static final int ERTEK = 0;




    private double[] measures;

    public Measurement(double[] measures) {
        for (double measure : measures) {
            if (measure < 0) {
                throw new IllegalArgumentException("measure cannot be less than 0!");
            }
        }
        this.measures = measures;
    }


    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measures.length; i++) {
            if (measures[i] > lower && measures[i] < upper) {
                return i;
            }
        }
        return -1;
    }


    public double minimum() {
        double minValue = measures[0];
        for (int i = 0; i < measures.length; i++) {
            if (measures[i] < minValue) {
                minValue = measures[i];
            }
        }
        return minValue;
    }


    public double maximum() {
        double maxValue = measures[0];
        for (int i = 0; i < measures.length; i++) {
            if (measures[i] > maxValue) {
                maxValue = measures[i];
            }
        }
        return maxValue;
    }


    public ExtremValues minmax() {
        double minValue = minimum();
        double maxValue = maximum();

        return new ExtremValues(minValue, maxValue);
    }


}


