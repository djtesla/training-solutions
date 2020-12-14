package week08d01;

public class Door {

    private int number;
    private int numberOfRotates;

    public int getNumber() {
        return number;
    }

    public Door(int number) {
        this.number = number;
    }



    public int getNumberOfRotates() {
        return numberOfRotates;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumberOfRotates(int numberOfRotates) {
        this.numberOfRotates = numberOfRotates;
    }
}
