package classstructureintegrate;

public class BankMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("100000-200000-300000", "Kis Jóska", 100000);
        BankAccount anotherBankAccount = new BankAccount("400000-500000-600000", "Majré Géza", 50000);
        System.out.println("Kezdeti adatok:");
        System.out.println(bankAccount.getInfo());
        System.out.println(anotherBankAccount.getInfo());

        System.out.println("Jóskának adok 20000 pénzt, Gézának 100000 pénzt:" );
        bankAccount.deposit(20000);
        anotherBankAccount.deposit(100000);
        System.out.println("Most az egyenlegek: "+ bankAccount.getInfo() + " és " + anotherBankAccount.getInfo());

        System.out.println("Elveszek Jóskától 15000 pénzt, Gézától 60000 pénzt:" );
        bankAccount.withdraw(15000);
        anotherBankAccount.withdraw(60000);
        System.out.println("Most az egyenlegek: "+ bankAccount.getInfo() + " és " + anotherBankAccount.getInfo());

        System.out.println("Jóska jófej és átutal Gézának 30000 pénzt:");
        bankAccount.transfer(anotherBankAccount, 30000);

        System.out.println("Most az egyenlegek: "+ bankAccount.getInfo() + " és " + anotherBankAccount.getInfo());



    }
}
