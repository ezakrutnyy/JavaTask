package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedInputFile {

    public static void main(String[] args) {
        /* [1] Буферизованное чтение из файла */
        List<String> result = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/io/input.txt"))) {
            result.addAll(reader.lines().collect(Collectors.toList()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(result);
    }
}
