package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+"
                + "(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+"
                + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher("ezakrutny.zakrutnyi@gmail.com");
        if (matcher.matches()) {
            System.out.println("Is a valid Email format");
        } else {
            System.out.println("Is not a valid Email format");
        }
    }
}
