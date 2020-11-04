package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    public boolean areTheyEqual(Product p) {
        return name.equals(p.name);
    }

    public boolean areTheyEqualRestricted(Product p) {
        return code.length() - p.code.length() <= 1 || code.length() - p.code.length() >= -1 ;
    }
}

