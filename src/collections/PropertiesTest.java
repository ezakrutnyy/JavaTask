package collections;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("message", "Is Moscow");
        props.setProperty("email", "test2@mail.ru");
        try (OutputStream out = Files.newOutputStream(Paths.get("resources/properties.txt"))) {
            props.store(out, "properties");
        }


        Properties props2 = new Properties();
        try (InputStream inp = Files.newInputStream(Paths.get("resources/properties.txt"))) {
            props2.load(inp);
        }

        System.out.println(props2.getProperty("message") + " -> " + props2.getProperty("email"));

        System.out.println(System.getProperties());
    }
}
