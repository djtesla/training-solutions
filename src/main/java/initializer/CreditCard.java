package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private long balance;
    private Currency currency;

    public static final List<Rate> RATES = new ArrayList<>();

    static {
        List<Rate> rates = new ArrayList<>();
        Currency[] currencies = Currency.values();

    }


    public CreditCard(long balance, Currency currency) {

    }

    public CreditCard(long balance) {

    }


    public long getBalance() {
        return 0;
    }

    public boolean payment(long amount, Currency currency) {
        return true;
    }


    public boolean payment(long amount) {
        return true;
    }


}
