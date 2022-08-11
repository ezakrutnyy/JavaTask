package io;

import com.google.common.base.Charsets;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferedInputFileWithCharset {

    public static void main(String[] args) {
        /* чтение из файла построчно 2 вариант*/
        try (final BufferedReader reader = Files.newBufferedReader(Paths.get("src/io/input.txt"), Charsets.UTF_8)) {
            while (reader.ready())
                System.out.println(reader.readLine());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
