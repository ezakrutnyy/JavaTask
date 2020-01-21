package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacer {
    public static void main(String[] args) {
        String inp = "dsds3sdsd22323dsdsd22323cdsd333 we22! ewee3232 232dse";
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(inp);
        String replaced = matcher.replaceAll("");
        System.out.println(inp);
        System.out.println(replaced);
    }
}
