package vizsgafelkészülés03;

import java.util.Objects;

public class Location implements Comparable<Location> {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location another) {
        this.x = another.x;
        this.y = another.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Location o) {
        return Integer.valueOf(x).compareTo(Integer.valueOf(o.x));
    }

    @Override
    public String toString() {
        return
                "x=" + x + ", y=" + y;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
