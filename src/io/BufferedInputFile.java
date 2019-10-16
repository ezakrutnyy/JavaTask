package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BufferedInputFile {

    static final String path  = "C:/Users/zakru/IdeaProjects/JavaTask/src/io/input.txt";

    public static void main(String[] args) {
        /* [1] Буферизованное чтение из файла */
        List<String> linkedList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String s;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while((s = reader.readLine()) != null) {
                linkedList.add(s.toUpperCase());
                sb.append(s).append("\n");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Collections.reverse(linkedList);
        System.out.println(linkedList);
    }


}
