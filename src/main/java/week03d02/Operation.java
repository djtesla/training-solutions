package week03d02;

public class Operation {

private int leftValue;
private int rightValue;

    public Operation(String input) {

        int i = input.indexOf('+');


        this.leftValue = Integer.parseInt(input.substring(0,i));
        this.rightValue = Integer.parseInt(input.substring(i));

        System.out.println(leftValue);
        System.out.println(rightValue);

    }


    public int getResult() {

        return leftValue + rightValue;
    }

    public static void main(String[] args) {

        Operation operation = new Operation("111+223");

        System.out.println(operation.getResult());


    }
}
