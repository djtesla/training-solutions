package week03;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {
        List<Position> listOfPositions = new ArrayList<>();

        listOfPositions.add(new Position("bigboss", 3000000));
        listOfPositions.add(new Position("cleaning supervisor", 100000));
        listOfPositions.add(new Position("CEO", 10000000));
        listOfPositions.add(new Position("anaqlyst", 300000));


        for (Position position : listOfPositions) {

            if (position.getBonus() > 150000) {
                System.out.println(position);

            }
        }


    }
}
