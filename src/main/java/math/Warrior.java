package math;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    public Point position;

       public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        Random rnd = new Random();
        stamina = rnd.nextInt(80) + 20;
        skill = rnd.nextDouble();
       }

    public int getStamina() {
        return stamina;
    }

    public Point getPosition() {
        return position;
    }

    public void move (Warrior warrior) {
           if (position.x > warrior.position.x) {
               position.x--;
           } else if (position.x == warrior.position.x) {

           } else {
               position.x++;
           }

        if (position.y > warrior.position.y) {
            position.y--;
        } else if (position.y == warrior.position.y) {

        } else {
            position.y++;
        }

        if (position.y == warrior.position.y && position.x == warrior.position.x) {
            this.attack(warrior);
        }
    }

    public void attack(Warrior warrior) {
           double skillRandom = new Random().nextDouble();
           if (skillRandom < skill) {
               Random rnd = new Random();
                int sebzes = rnd.nextInt(4);
               warrior.stamina = warrior.stamina - sebzes;
           }
    }
    public boolean isAlive() {
           return stamina > 0;
    }

    public String toString() {
           return name + ": (" + position.getX() + ", " + position.getY() + ") " + stamina ;
    }

}
