package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Евгений on 27.07.2017.
 */
public class StrBrowseMethods {
    public static void main(String[] args) {
        // Создание через char[]
        char[] m = new char[]{'m','i','l','k'};
        String str = new String(m);
        System.out.printf("Вы ввели строку %s \n",str);


        System.out.println("========part1=========");
        //Интернирование строк
        String st1 = "Hello";
        String st2 = "Hello";
        System.out.println(st1.equals(st1));
        System.out.println(st1==st2);

        System.out.println("========part2==========");
        String st3 = new String("Hello");
        String st4 = "Hello";
        System.out.println(st3.equals(st4));
        System.out.println(st3==st4);

        System.out.println("=====part3=====execute intern()==========");
        String st5 = new String("Hello");
        String st6 = "Hello";
        st5 = st5.intern();
        System.out.println(st5.equals(st6));
        System.out.println(st5==st6);

        System.out.println("=====sorting String==========");
        //Сортировка строк
        String[] arrStr = new String[]{"kivi","banana","apple","Orange","watermelon","melon"};
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));

        System.out.println("=====comparing String==========");
        //сравнение двух строк
        String compStr1 = "appla";
        String compStr2 = "applb";
        System.out.println(compStr1.compareTo(compStr2));


        System.out.println("=====Replace  String==========");
        String decaf = "   Decaffeinated    ";
        decaf.trim();
        System.out.println("Threre is no " + decaf.substring(2,9) + " in " + decaf + " coffee");

        System.out.println("=====execute concat()==========");
        // concat работает заметно быстрее чем оператор +
        // но при concat создается новая строка String() без интернирования строк
        String s1 = "Hello";
        String s2 = " my ";
        String s3 = "world!";
        String s4 = "Hello my world!";
        String resConcat = s1.concat(s2).concat(s3);
        System.out.println("resConcat "+resConcat);
        System.out.println("Equal references ? " + (resConcat == s4));
        System.out.println("Have equal contents ? " + resConcat.equals(s4));


        System.out.println("---------------------------------CharAt()");
        char c = str.charAt(3);
        System.out.println(c);

        System.out.println("--------------------------------toCharArray()");
        char[] cMas =  str.toCharArray();
        System.out.println(cMas);

        System.out.println("--------------------------------getChars()");
        char[] cMas2 = new char[3];
        str.getChars(1,4,cMas2,0);
        System.out.println(cMas2);

        System.out.println("--------------------------------contains()");
        System.out.println(str.contains("ks"));
        System.out.println(str.contains("ilk"));

        System.out.println("--------------------------------contentEquals()");
        System.out.println(str.contentEquals("ks"));
        System.out.println(str.contentEquals("milk"));

        System.out.println("--------------------------------valueOf()");
        System.out.println(str.valueOf(13));

    }
}
