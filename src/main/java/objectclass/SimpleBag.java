package objectclass;

import java.util.List;
import java.util.Objects;

public class SimpleBag {

    private List<Object> items;

    public SimpleBag(List<Object> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleBag simpleBag = (SimpleBag) o;
        return Objects.equals(items, simpleBag.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

   /* public void putItem(Object item) {

    }
    public boolean isEmpty() {

    }

    public int size() {

    }

    public void beforeFirst() {



    }
    public Object next() {

    }

    public boolean contains(Object item) {

    }

    public int getCursor() {

        return cursor;

    }*/
}
