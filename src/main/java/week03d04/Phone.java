package week03d04;

public class Phone {

    private int prefix;
    private int number;

    public Phone(int prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getNumber() {
        return number;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
