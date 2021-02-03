package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class OnlineShop {

    private List<ShoppingList> shoppingLists = new ArrayList<>();


    public List<ShoppingList> shoppingLists() {
        return shoppingLists;
    }


    public void uploadShoppingLists() {

        String fileName = "shoppinglists.txt";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {

            shoppingLists = readFromFile(fileName, reader);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }


    private List<ShoppingList> readFromFile(String fileName, BufferedReader reader) throws IOException {

        String line;
        while ((line = reader.readLine()) != null) {
            ShoppingList shoppingList = getShoppingListPerLine(line);
            shoppingLists.add(shoppingList);
        }
        return shoppingLists;
    }


    private ShoppingList getShoppingListPerLine(String line) {
        String[] lineData = line.split(" ");
        String regNumber = lineData[0];
        List<String> products = getProductListPerLine(lineData[1]);
        return new ShoppingList(regNumber, products);
    }


    private List<String> getProductListPerLine(String productsData) {
        List<String> products = new ArrayList<>();
        for (String productName : productsData.split(",")) {
            products.add(productName);
        }
        return products;
    }


    public String getShoppingListStrByRegNumber(String regNumber) {

        for (ShoppingList shoppingList : shoppingLists) {
            if (shoppingList.getRegNumber().equals(regNumber)) {
                Set<String> sorted = new TreeSet<>(shoppingList.getProducts());
                return sorted.toString();
            }
        }
        throw new IllegalStateException("No list exists with the given regNumber: " + regNumber);
    }


    public ShoppingList getShoppingListByRegNumber(String regNumber) {

        for (ShoppingList shoppingList : shoppingLists) {
            if (shoppingList.getRegNumber().equals(regNumber)) {
                return shoppingList;
            }
        }
        throw new IllegalStateException("No list exists with the given regNumber: " + regNumber);
    }


    public int getNumberOfProductPerName(String name) {
        return getStatistics().get(name);
    }



    public int getNumberOfProductTypesPerRegNumber(String regNumber) {

        ShoppingList shoppingListFocused = getShoppingListByRegNumber(regNumber);
        Set<String> productTypes = new TreeSet<>(shoppingListFocused.getProducts());
        System.out.println(productTypes);
        return productTypes.size();
    }


    public Map<String, Integer> getStatistics() {

        Map<String, Integer> statistics = new TreeMap<>();
        for (ShoppingList shoppingList : shoppingLists) {
            setValues(statistics, shoppingList);
        }
        return statistics;
    }


    private void setValues(Map<String, Integer> statistics, ShoppingList shoppingList) {

        int value;
        for (String nameFocused : shoppingList.getProducts()) {
            if (statistics.get(nameFocused) != null) {
                value = statistics.get(nameFocused) + 1;
            } else {
                value = 1;
            }
            statistics.put(nameFocused, value);
        }
    }



}


/*    Mai Junior/Mid-level feladat:
        Adott egy fájl melyben online bevásárlások találhatók. A fájl a még ki nem szállított rendeléseket tartalmazza.
        Egy sorban egy egyedi azonosító és utána a termékek neve van felsorololva. Minden vásárlás legalább 2 termékből áll.
        ```
        A233 bread,tomato,flour,sugar
        A312 sugar,beer,apple,pear
        B3402 meet,soda,cola,bbq_sauce
        B341 pasta,passata,basil,cheese
        A10 corn,hot_dog,rolls
        CM231 beer,chips
        C123 pepper,salt,rosmary,pizza_dough,passata,oregano
        W34111 pasta,sugar,rosmary,cheese,meet,carrot,potato,tomato
        K8921 wine,soda
        ```
        Olvasd be a fájlt és tárold el az adatokat a memóriában, majd oldd meg a következő feladatokat.
        1. Egyedi azonosító alapján legyenek lekérdezhetőek a vásárolt termékek ABC sorrendben.
        2. Számoljuk össze, egy termék neve alapján, hogy abból a termékből mennyit adtak el.
        3. Adjuk vissza egy vásárlási azonosító alapján, hogy hány termék szerepel a vásárlásban.
        4. Készíts statisztikát melyben visszaadod, hogy az egyes termékek hányszor szerepelnek a fájlban.*/
