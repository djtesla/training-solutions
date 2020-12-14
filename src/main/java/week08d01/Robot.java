package week08d01;

public class Robot {

    private Position position;

    public Robot() {
        this.position = new Position();
    }

    public Position move(String moves) {

        char[] moveChars = moves.toCharArray();

        for (char c : moveChars) {

            c= Character.toUpperCase(c);

            switch (c) {

                case 'F':
                    moveUp();
                    break;

                case 'L':
                    moveDown();
                    break;

                case 'J':
                    moveRight();
                    break;

                case 'B':
                    moveLeft();
                    break;

                default:
                    throw new IllegalArgumentException("Unknown key");
            }
        }
        return position;
    }


    public void moveUp() {
        position.setY(position.getY()+1);

    }

    public void moveDown() {
        position.setY(position.getY()-1);
    }

    public void moveRight() {
        position.setY(position.getX()+1);
    }

    public void moveLeft() {
        position.setY(position.getX()-1);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}

/*    A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot
        az origóban van. A robot négy irányba képes mozogni fel, le, balra és jobbra. A week08d01.Robot
        osztályban írj egy move() metódust ami egy karaktersorozatot vár.  pl: FFLLLLLBBBBJJJJJJJ, ahol
        az F = fel, L=le, B=bal, J=jobb. A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
        A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés, hogyha más karaktert is
        tartalmaz a paraméter String nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!*/
