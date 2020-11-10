package week03;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {
        List<Position> listOfPositions = new ArrayList<>();

        listOfPositions.add(new Position("bigboss", 3000000));
        listOfPositions.add(new Position("cleaning supervisor", 100000));
        listOfPositions.add(new Position("CEO", 10000000));
        listOfPositions.add(new Position("analyst", 300000));


        for (Position position : listOfPositions) {

            if (position.getBonus() > 150000) {
                System.out.println(position);

            }
        }


    }
}
