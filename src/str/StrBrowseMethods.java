package str;

import org.apache.commons.compress.utils.Lists;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Евгений on 27.07.2017.
 */
public class StrBrowseMethods {
    public static void main(String[] args) {

        System.out.println("========part0=========");

        // Создание через char[]
        char[] m = new char[]{'m','i','l','k'};
        String str = new String(m);
        System.out.printf("Вы ввели строку from char[] %s \n",str);

        // Создание через bytes[]
        byte[] bytesStr = "Привет, hello!".getBytes(StandardCharsets.UTF_8);
        String fromBytes = new String(bytesStr, StandardCharsets.UTF_8);
        System.out.printf("Вы ввели строку from byte[] %s \n", fromBytes);

        System.out.println("========part1=========");
        //Интернирование строк
        String st1 = "Hello";
        String st2 = "Hello";
        System.out.println(st1.equals(st2));
        System.out.println(st1==st2);

        System.out.println("=====part2=====execute intern()==========");
        String st5 = new String("Hello2").intern();
        String st6 = new String("Hello2").intern();
        System.out.println(st5.equals(st6));
        System.out.println(st5==st6);

        System.out.println("=====sorting String==========");
        //Сортировка строк
        String[] arrStr = new String[]{"kivi","banana","apple","Orange","watermelon","melon"};
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));
        Arrays.sort(arrStr, Comparator.naturalOrder());
        System.out.println(Arrays.toString(arrStr));
        Arrays.sort(arrStr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arrStr));

        System.out.println("=====comparing String==========");
        //сравнение двух строк
        String compStr1 = "applea";
        String compStr2 = "appleb";
        System.out.println(compStr1.compareTo(compStr2));


        System.out.println("=====Replace  String==========");
        String decaf = "   Decaffeinated    ";
        decaf = decaf.trim();
        System.out.println("Threre is no " + decaf.substring(2,9) + " in " + decaf + " coffee");

        System.out.println("---------------------------------CharAt()");
        char c = str.charAt(3);
        System.out.println(c);

        System.out.println("--------------------------------toCharArray()");
        char[] cMas =  str.toCharArray();
        System.out.println(Arrays.toString(cMas));

        System.out.println("--------------------------------getChars()");
        char[] cMas2 = new char[3];
        str.getChars(1,4,cMas2,0);
        System.out.println(cMas2);

        System.out.println("--------------------------------contains()");
        System.out.println(str.contains("ks"));
        System.out.println(str.contains("ilk"));

        System.out.println("--------------------------------contentEquals()");
        System.out.println(str.contentEquals("milk"));
        System.out.println(str.contentEquals("MILK"));

        System.out.println("--------------------------------valueOf()");
        float f = 12.12F;
        System.out.println(String.valueOf(f));

    }
}
