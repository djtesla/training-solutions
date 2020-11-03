package array;

public class ArrayHandler {

    boolean contains(int[] source, int itemToFind) {
        boolean valasz = false;
        for (int item: source) {

           if (item == itemToFind) {
               valasz = true;
           }
        }
        return valasz;
    }

    int find(int[] source, int itemToFind){
    int valasz = -1 ;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                valasz = i;
            }
        }
        return valasz;
    }
}
