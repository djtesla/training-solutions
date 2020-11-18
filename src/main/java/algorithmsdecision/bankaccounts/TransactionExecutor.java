package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {

        BankAccount accountToTransact = null;

        for (Transaction transaction: transactions) {

            if (isIncluded(transaction.getAccountNumber(), accounts) ) {

                accountToTransact = getAccount(transaction.getAccountNumber(),accounts);
                if (transaction.isCredit()) {
                    accountToTransact.deposit(transaction.getAmount());
                } else {
                    accountToTransact.withdraw(transaction.getAmount());

                }
            }
        }

    }

    public boolean isIncluded (String account, List<BankAccount> accounts) {

            for (BankAccount bankAccount : accounts) {

                if (bankAccount.getAccountNumber() == account) {

                    return true;
                }
            }
        return false;

    }
    public BankAccount getAccount (String accountNumber, List<BankAccount> accounts) {
            for (BankAccount bankAccount : accounts) {

                if (bankAccount.getAccountNumber() == accountNumber) {

                    return bankAccount;
                }
            }
            return null;
    }


}
