package introconstructors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant (String name, int numberOfTables) {
        this.name = name;
        capacity = numberOfTables * 4;
        menu = this.loadUpMenu();

    }

    public List<String> loadUpMenu() {

      return Arrays.asList("Pörkölt", "Tócsni", "Sztrapacska");


    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Articsóka",10);

        restaurant.loadUpMenu();

        System.out.println("Az étterem neve: " + restaurant.getName());
        System.out.println("Az étterem kapacitása: " + restaurant.getCapacity());
        System.out.println("Az étterem menüje: " + restaurant.getMenu());
    }
}
