package gyakorlás;

public enum EnumGyak {

    NOKIA("low", 30_000), ALCATEL("medium", 20_000), IPHONE("high",  100_000);

    private int price;
    private String popularity;

    EnumGyak(String popularity, int price) {
        this.popularity = popularity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getPopularity() {
        return popularity;
    }


    public static void main(String[] args) {

    }
}
