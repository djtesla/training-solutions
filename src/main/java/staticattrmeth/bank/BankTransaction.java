package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {

    //public static int numberOfTransactions;
    //public static long sumOfTransactions;
    public static long currentMinValue;
    public static long currentMaxValue;
    private int trxValue;


    public static void initTheDay() {
        currentMinValue = 0;
        currentMaxValue = 0;

    }

    public BankTransaction(int trxValue) {
        currentMinValue = trxValue;
        currentMaxValue = trxValue;
        this.trxValue = trxValue;

    }

    public static BigDecimal averageOfTransaction() {

    return new BigDecimal(1000);
    }

    public static long getCurrentMinValue() {
        return currentMinValue;

    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;

    }

    public long getTrxValue() {
        return trxValue;
    }

    public static BigDecimal getSumOfTrxs() {

        return new BigDecimal(1000);
    }







}
