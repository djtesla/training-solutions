package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();


    public List<Trooper> getTroopers() {
        return troopers;
    }


    public void addTrooper(Trooper trooper) {

        if ("".equals(trooper.getName()) || trooper.getName() == null) {
            throw new IllegalArgumentException("Name must not be empty.");
        }

        if (trooper == null) {
            throw new IllegalArgumentException("Trooper cannot be null!");
        }

        troopers.add(trooper);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Position cannot be null!");
        }

        Trooper closestTrooper = findClosestTrooper(target);
        moveTrooper(closestTrooper, target);

    }


    public void moveTrooperByName(String name, Position target) {

        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException("Name must not be empty.");
        }

        if (target == null) {
            throw new IllegalArgumentException("Position cannot be null!");
        }

        moveTrooper(findTrooperByName(name), target);

    }


    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        return new Trooper(null);
    }



        private Trooper findClosestTrooper (Position target){

            Trooper closestTrooper = null;

            for (Trooper trooper : troopers) {

                if (closestTrooper == null || trooper.distanceFrom(target) < closestTrooper.distanceFrom(target)) {
                    closestTrooper = trooper;

                }
            }

            return closestTrooper;
        }


        private void moveTrooper (Trooper trooper, Position target){
            trooper.changePosition(target);


        }

    }


