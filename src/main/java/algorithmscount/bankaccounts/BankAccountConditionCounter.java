package algorithmscount.bankaccounts;

import java.util.ArrayList;
import java.util.List;

public class BankAccountConditionCounter {


    public int countWithBalanceGreaterThan (List<BankAccount> accounts, int lowerBound) {
        int i = 0;

        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getBalance() > lowerBound) {
                i++;
            }
        }
        return i;


    }

    public static void main(String[] args) {

        BankAccountConditionCounter conditioner = new BankAccountConditionCounter();

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("Kis Béla", "100000000001",100_000 ));
        accounts.add(new BankAccount("Kis Béla", "100000000001",150_000 ));
        accounts.add(new BankAccount("Kis Béla", "100000000001",160_000 ));
        accounts.add(new BankAccount("Kis Béla", "100000000001",170_000 ));

        System.out.println(conditioner.countWithBalanceGreaterThan(accounts, 150_000));

    }
}
