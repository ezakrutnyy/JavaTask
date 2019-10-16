package io;

import com.google.common.base.Charsets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedInputFileWithCharset {

    static final String path  = "C:/Users/zakru/IdeaProjects/JavaTask/src/io/input.txt";

    public static void main(String[] args) {
        /* чтение из файла построчно 2 вариант*/
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), Charsets.UTF_8))) {
            while(reader.ready())
                System.out.println(reader.readLine());
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
