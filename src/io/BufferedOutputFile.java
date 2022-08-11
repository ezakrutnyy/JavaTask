package io;

import com.google.common.collect.Lists;

import java.io.PrintWriter;
import java.util.List;

public class BufferedOutputFile {
    public static void main(String[] args) {

        List<String> lst = Lists.newArrayList("one", "two", "three", "four", "five");
        // сокращенный вариант
        try (PrintWriter out = new PrintWriter("src/io/output.txt")) {
            lst.forEach(out::println);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
