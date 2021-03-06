package week06d02;

public class Product {

    private String name;
    private Category category;
    private int price;

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public Category getCategory() {

        return category;
    }

    public int getPrice() {

        return price;
    }
}


/*Junior/Mid-level mai feladata:
        Hozz létre egy week06d02.Product osztályt melynek adattagjai a név, kategória és ár,
        rendre, String, String int. Készíts egy Store osztályt benne egy Product listával, amit konstruktorban
        kap meg. Legyen egy getProductByCategoryName(Category), ami visszaadja, hogy a paraméterül kapott kategóriából
        hány darab van a listában.
        Bónusz: A kategória legyen enum FROZEN,DAIRY,BAKEDGOODS,OTHER felsorolókkal.*/


