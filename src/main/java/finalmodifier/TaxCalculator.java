package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 0.27;

    public static final TaxCalculator taxcalculator = new TaxCalculator();

    public double tax(double price) {

        return VAT * price;
    }

    double priceWithTax(double price) {

        return  price + price * VAT;
    }

    public static void main(String[] args) {

        System.out.println(taxcalculator.tax(1000));
        System.out.println(taxcalculator.priceWithTax(1000));
    }
}
