package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeRegex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):([0-5][0-9])$");
        Matcher matcher = pattern.matcher("1:55");
        if (matcher.matches()) {
            System.out.println("Is a valid time in 24 hour format");
        } else {
            System.out.println("Is not a valid time in 24 hour format");
        }
    }
}
