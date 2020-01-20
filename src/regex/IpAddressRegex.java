package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressRegex {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

        Matcher matcher = pattern.matcher("10.233.190.255");
        if (matcher.matches()) {
            System.out.println("Is a valid ip address format");
        } else {
            System.out.println("Is not a valid ip address format");
        }
    }
}
