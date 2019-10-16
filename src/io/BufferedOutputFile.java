package io;

import com.google.common.collect.Lists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class BufferedOutputFile {

    static final String path  = "C:/Users/zakru/IdeaProjects/JavaTask/src/io/output.txt";

    public static void main(String[] args) {

        List<String> lst = Lists.newArrayList("one", "two", "three", "four", "five");
//        try(PrintWriter out = new PrintWriter(
//                new BufferedWriter(
//                        new FileWriter(path)), true)) {
//            lst.stream().forEach(out::println);
//        } catch (Exception ex) {
//            System.err.println(ex);
//        }

        // сокращенный вариант
        try(PrintWriter out = new PrintWriter(path)) {
            lst.stream().forEach(out::println);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
