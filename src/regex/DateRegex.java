package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRegex {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)$");
        final Matcher matcher = pattern.matcher("20.01.2022");
        if (matcher.matches()) {
            System.out.println("Is a valid date format");
        } else {
            System.out.println("Is not a valid date format");
        }
    }
}
