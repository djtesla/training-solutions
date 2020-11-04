package math;

public class Game {
    public static void main(String[] args) {

        Point position1 = new Point(10,5);
        Point position2= new Point(1,1);

        Warrior warrior1 = new Warrior("Géza Long", position1);
        Warrior warrior2 = new Warrior("Béla Káró", position2);

        System.out.println("Kezdő állás:");
        System.out.println(warrior1.toString());
        System.out.println(warrior2.toString());

        for (int i = 1; warrior1.isAlive() && warrior2.isAlive() ; i++) {
            System.out.println(i+". forduló:");
            warrior1.move(warrior2);
            warrior2.move(warrior1);

            System.out.println(warrior1.toString());
            System.out.println(warrior2.toString());


        }
        System.out.println("Játék vége! Az egyik warrior megmurdált.");
    }

}
