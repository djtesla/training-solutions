package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {


    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccounts, int min) {

        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getBalance() > min) {
                return true;
            }
        }
        return false;
    }



}
