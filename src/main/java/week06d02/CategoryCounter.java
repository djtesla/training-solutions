package week06d02;

public class CategoryCounter {

    private Category category;
    private int quantity;

    public CategoryCounter(Category category, int quantity) {
        this.category = category;
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
