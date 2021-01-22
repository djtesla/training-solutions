package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path folder) {

        Path path = folder.resolve(bankAccount.getAccountNumber() + ".dat");

        try (DataOutputStream stream = new DataOutputStream(new BufferedOutputStream
                (Files.newOutputStream(path)))) {

            stream.writeUTF(bankAccount.getAccountNumber());
            stream.writeUTF(bankAccount.getOwner());
            stream.writeDouble(bankAccount.getBalance());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }


    public BankAccount loadAccount(InputStream stream) {

        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(stream))) {

            return new BankAccount(dataInputStream.readUTF(), dataInputStream.readUTF(),
                    dataInputStream.readDouble());

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


}




