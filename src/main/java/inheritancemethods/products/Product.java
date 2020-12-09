package inheritancemethods.products;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }


    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
    }

    public BigDecimal totalWeight(int pieces) {

        return new BigDecimal(0);
    }
}
