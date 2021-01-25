package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {


    public void saveTransactions(Path path, List<Transaction> transactions) {
        StringBuilder content = new StringBuilder();
        try (ZipOutputStream stream = new ZipOutputStream(new BufferedOutputStream
                (Files.newOutputStream(path)))) {

            for (Transaction transaction : transactions) {

                String fileName = Long.toString(transaction.getId());
                //StringBuilder content = new StringBuilder();

                content.append(transaction.getTime()).toString();
                content.append("\n");
                content.append(transaction.getAccount());
                content.append("\n");
                content.append(transaction.getAmount());
                content.append("\n");

                stream.putNextEntry(new ZipEntry(fileName));
                stream.write((content.toString().getBytes()));

            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }


    }
}
