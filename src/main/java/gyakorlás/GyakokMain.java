package gyakorlás;


import java.util.Scanner;

public class GyakokMain {


    public static void main(String[] args) {

        Employee employee1 = new Employee(200);
        Employee employee2 = employee1;

        int x = employee1.hashCode();
        int y = employee2.hashCode();


        System.out.println(x + " : " +y);



    }
}











