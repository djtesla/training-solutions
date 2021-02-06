package properties;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {

    private static final String ENCODING_UTF8 = "UTF-8";
    private Properties properties;

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
            properties = readProperties(is);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }


    public DatabaseConfiguration(File file) {
        try (InputStream is = new FileInputStream(file)) {
            readProperties(is);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }


    public Properties readProperties(InputStream is) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(is, ENCODING_UTF8)) {
            Properties p = new Properties();
            p.load(reader);
            return p;
        }
    }


    public String getHost() {
        return properties.getProperty("db.host");
    }


    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }


    public String getSchema() {
        return properties.getProperty("db.schema");
    }

}

