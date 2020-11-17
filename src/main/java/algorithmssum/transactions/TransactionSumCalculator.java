package algorithmssum.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionSumCalculator {

    private List<Transaction> transactions = new ArrayList<>();


    public void addTransaction (Transaction transaction) {
        transactions.add(transaction);

    }


    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction:transactions) {
            if (transaction.getTransactionOperation() == TransactionOperation.CREDIT) {
                sum +=transaction.getAmount();
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TransactionSumCalculator transactionSumCalculator = new TransactionSumCalculator();

        transactionSumCalculator.addTransaction(new Transaction("1000-2000-3000",TransactionOperation.DEBIT, 10000));
        transactionSumCalculator.addTransaction(new Transaction("1000-2000-3000",TransactionOperation.CREDIT, 30000));
        transactionSumCalculator.addTransaction(new Transaction("1000-2000-3000",TransactionOperation.DEBIT, 50000));
        transactionSumCalculator.addTransaction(new Transaction("1000-2000-3000",TransactionOperation.CREDIT, 20000));

        System.out.println(transactionSumCalculator.sumAmountOfCreditEntries(transactionSumCalculator.transactions));
    }



}
