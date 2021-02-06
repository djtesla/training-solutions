package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) {

        Properties p = new Properties();
        p.setProperty("host", "training360.com");
        System.out.println(p.getProperty("port", "nincsendevandefault"));

        Properties pRead = new Properties();


        try (InputStream is = PropertiesTest.class.getResourceAsStream("/welcome.properties")) {
            pRead.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        System.out.println(pRead.getProperty("welcome.message"));

        Properties p3 = new Properties();
        p3.setProperty("host", "training360.com");

        try (Writer wr = new FileWriter("config.properties")) {
            p3.store(wr, null);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }


    }
}
