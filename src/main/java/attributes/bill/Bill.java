package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<Item> items = new ArrayList<>();


    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalPrice() {
        double sum = 0;
    for (Item item : items) {
        sum += item.getQuality() * item.getPrice();

        }
    return sum;
    }


    public static void main(String[] args) {
        Bill bill = new Bill();

        bill.addItem(new Item("Löncskonzerv", 2, 1490));
        bill.addItem(new Item("Papaya", 16, 990));
        bill.addItem(new Item("Sörnyitó", 3, 490));

        System.out.println(bill);
        System.out.println(bill.calculateTotalPrice());

    }
}
