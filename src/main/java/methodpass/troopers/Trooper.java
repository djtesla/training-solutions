package methodpass.troopers;

public class Trooper {

    private String name;
    private Position position;


    public Trooper(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty.");

        }
        this.name = name;
        position = new Position(0, 0);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {

        return name;

    }

    private boolean isEmpty(String name) {
        return name == null ||name.equals("");
    }

    public void changePosition(Position target) {

        if (target == null) {
            throw new IllegalArgumentException("Position cannot be null!");
        }

        position = new Position(target.getPosX(), target.getPosY());
    }

    public double distanceFrom(Position target) {

        if (target == null) {
            throw new IllegalArgumentException("Position cannot be null!");
        }

        return position.distanceFrom(target);

    }

}
