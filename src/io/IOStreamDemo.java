package io;

import com.google.common.base.Charsets;

import java.io.*;

public class IOStreamDemo {

    public static void main(String[] args) {

        String path  = "C:/Users/zakru/IdeaProjects/JavaTask/src/io/input.txt";

        int val;
        /* Чтений из файла побайтово вариант 1 */
        try(BufferedInputStream bfr = new BufferedInputStream(
                new FileInputStream(path))) {
            while ((val = bfr.read()) != -1) {
                //System.out.println(val);
            }
        } catch (Exception ex){
            System.err.println(ex);
        }

        /* Чтений из файла побайтово вариант 2 */
        try(BufferedInputStream bfr = new BufferedInputStream(
                new FileInputStream(path))) {
            byte[] res = new byte[bfr.available()];
            bfr.read(res);
            //System.out.println(Arrays.toString(res));
        } catch (Exception ex){
            System.err.println(ex);
        }



    }
}
