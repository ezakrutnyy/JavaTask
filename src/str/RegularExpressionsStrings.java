package str;

import java.util.Arrays;

/**
 * Created by Евгений on 08.05.2018.
 */
public class RegularExpressionsStrings {
    public static void main(String[] args) {
        String s = "+1234";
        // matches - ищет совпадения вначале + - , либо может отсутствовать => дальше чилсо
        System.out.println(s.matches("(-|\\+)?\\d+"));


        //split разделяет по регулярным выражениям
        String splitStr = "Then when open =  strowberry -  cut move ! london.";
        System.out.println(Arrays.toString(splitStr.split("\\W+")));

        //replace заменяем в строке значение на подстроку
        System.out.println(splitStr.replaceAll("cut|london","hello"));
        System.out.println(splitStr.replaceAll("\\w+","A"));

        //1) выражение начинается с прописной буквы и заканчивается на знак .
        String lye = "Xaa AAa.";
        if (lye.matches("^[A-Z].+[.]$")) {
            System.out.println("SUCCESS");
        }

    }
}
