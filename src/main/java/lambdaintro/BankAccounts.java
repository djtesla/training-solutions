package lambdaintro;

import java.text.Collator;
import java.util.*;

public class BankAccounts {

    private List<BankAccount> bankAccounts;


    public BankAccounts(List<BankAccount> bankkAccouns) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> sortByAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }




    public List<BankAccount> sortByAbsBalance() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.comparing(account -> Math.abs(account.getBalance())));
        return sorted;
    }



    public List<BankAccount> sortByBalanceDesc() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return sorted;
    }

    public List<BankAccount> sortByNameThenAccountWithNullFirst() {
        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sorted.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator)).thenComparing(BankAccount::getAccountNumber));
        return sorted;
    }


    public static void main(String[] args) {
        BankAccounts accounts = new BankAccounts(Arrays.asList(
                new BankAccount("3", "John Doe", 100.0),
                new BankAccount("1", "John Doe", 100.0),
                new BankAccount("2", "John Doe", 100.0),
                new BankAccount("5", null, 100.0),
                new BankAccount("4", "John Doe", 100.0)

        ));

        //List<BankAccount> sorted  = accounts.sortByNameThenAccountWithNullFirst();

    }


}
