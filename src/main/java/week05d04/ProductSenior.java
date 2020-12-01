package week05d04;

public class ProductSenior {

    private long price;
    private Currency currency;

    public ProductSenior(long price, Currency currency) {

        if (currency == null || ! isValid(price)) {
            throw new IllegalArgumentException("invalid price or no currency!");
        }

        this.price = price;
        this.currency = currency;
    }


    public long getPrice() {
        return price;
    }


    private boolean isValid(long price) {
        return price > 0;
    }



    public double convertPrice(Currency currency) {

        if (currency == null || ! isValid(price)) {
            throw new IllegalArgumentException("invalid price or no currency!");
        }

        String rates = this.currency.name() + "-" + currency.name();

        switch (rates) {

            case "HUF-USD":
                return (double) price / 300;

            case "USD-HUF":
                return (double) price * 300;

            case "HUF-HUF":
            case "USD-USD":
                return (double) price;

        }
        return 0;


    }


}





   /* Mai Senior feladat:
        Készíts egy osztályt Product néven, melynek van egy price (long) és egy currency (String) mezője.
        A Product a konstruktorában ellenőrizze a currency mezőt, melynek az értéke vagy HUF, vagy USD lehet.
        Készíts egy metódust convertPrice néven, melynek egy paramétere van (currency) és visszaadja a currency-nek
        megfelelő összeget (double). Használjunk 300 forintos átváltási árfolyamot! Példa: ha a Product-ot létrehozzuk
        a következőképp: new Product(150, "HUF"), majd meghívjuk a convertPrice-ot "USD" paraméterrel, akkor az elvárt
        visszatérési érték 0.5.
        Bónusz feladat: írjunk teszteket
        Bónusz feladat 2: Használjunk enum-ot String helyett a pénznem reprezentációjára*/