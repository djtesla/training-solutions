package abstractclass;

public class Duck extends  Bird {

    @Override
    public void move() {
        System.out.println("Hápháp");
    }



    public static void main(String[] args) {
        Animal animal = new Duck();
        animal.move();
        //animal.layEggs(5);
        Bird bird = new Duck();
        bird.move();
        bird.layEggs(5);

    }

}
