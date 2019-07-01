package example;

import com.google.common.base.Splitter;
import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Chapter1 {

    final public static Logger logger  = Logger.getLogger("Chapter1");

    public static void main(String[] args) {

        System.out.println("*********************************Example1********************************************");
        /*
        * Перевод целого десятичного числа:
        * - to Binary()
        * - to Oct
        * - to Hex
        * */
        Integer inp = 14;

        String binary = Integer.toBinaryString(inp);
        String octal = Integer.toOctalString(inp);
        String hex = Integer.toHexString(inp);


        System.out.println("Binary: "+binary);
        System.out.println("Octal: "+octal);
        System.out.println("Hex: "+hex);

        /*
         * Обратный перевод в десятичное число
         * - to Binary()
         * - to Oct
         * - to Hex
         * */
        System.out.println("Integer By Binary: "+Integer.parseInt(binary, 2));
        System.out.println("Integer By Oct: "+Integer.parseInt(octal, 8));
        System.out.println("Integer By Hex: "+Integer.parseInt(hex, 16));

        /*
        * Перевод из числа с плавающей точкой , 10 системы исчесления, в 16 ричную
        * и обратно
        * */

        Double d = 14.8;
        hex = Double.toHexString(d);
        System.out.println("Double hex: "+hex);
        System.out.println("Double: "+Double.parseDouble(hex));

        System.out.println("*********************************Example2********************************************");
        /*
        * Нормализация угла
        * */
        int ungle = 362;
        int res;
        if (ungle%360>=0) {
            res = ungle%360;
        } else {
            res = ungle%360+360;
        }
        System.out.println("Ungle:"+res);

        System.out.println("Ungle Math.floorMod():"+Math.floorMod(ungle, 360));


        System.out.println("*********************************Example3********************************************");
        /* Максимальное целочисленное значение из 3х */
        int a = 110;
        int b = 111;
        int c = 10;
        int max = a;
        if (a >= b) {
            if (a < c) {
                max = Math.max(a, c);
            }
        } else {
            max = Math.max(b, c);
        }
        System.out.println("Max: "+max);

        System.out.println("*********************************Example6********************************************");
        /* Написать факториал 1000!, используя BigInteger */
        BigInteger inpFact = BigInteger.valueOf(1000);
        try {
            System.out.println(String.format("factotial by recursion %d : %d", inpFact, factotial(inpFact)));
            System.out.println(String.format("factotial by for cicle %d : %d", inpFact, factorial2(inpFact)));
        } catch (RuntimeException ex) {
            logger.info(ex.getLocalizedMessage());
        }

    }

    public static BigInteger factotial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) throw new IllegalArgumentException("Error! Input number is negate");

        if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;

        return n.multiply(factotial(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger factorial2(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) throw new IllegalArgumentException("Error! Input number is negate");

        if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;

        BigInteger res = BigInteger.ONE;
        for (;n.compareTo(BigInteger.ONE)> 0; n = n.subtract(BigInteger.ONE)) {
            res = res.multiply(n);
        }
        return  res;
    }
}