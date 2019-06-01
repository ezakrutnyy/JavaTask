package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Евгений on 06.11.2018.
 */
public class AutoCloseableDemo {

    public static void main(String[] args) throws IOException {
        readingBuffer();
    }

    public static void readingBuffer() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("path"))) {
            br.read();
        }
    }
}
