package io;

import java.io.StringReader;

public class MemoryStringInput {

    final static String s = new String("aaaaa bbbb ccccc");

    public static void main(String[] args) {
        int c;
        try(StringReader in = new StringReader(s)) {
            while ((c = in.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (Exception ex ) {
            System.err.println(ex);
        }
    }
}
