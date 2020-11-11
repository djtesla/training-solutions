package typeconversion.whichtype;

public enum Type {
    BYTE(Byte.MIN_VALUE, Byte.MAX_VALUE),
    SHORT(Short.MIN_VALUE, Short.MAX_VALUE),
    INT(Integer.MIN_VALUE, Integer.MAX_VALUE),
    LONG(Long.MIN_VALUE, Long.MAX_VALUE);


    private double min;
    private double max;

    Type(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
