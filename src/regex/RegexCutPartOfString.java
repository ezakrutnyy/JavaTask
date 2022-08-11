package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCutPartOfString {

    public static void main(String[] args) {
        String inp = "RUSSIA (code:RUS)";
        Pattern pattern = Pattern.compile(".+:(.+)\\)");
        Matcher matcher = pattern.matcher(inp);
        String res = matcher.replaceAll("$1");
        System.out.println(res);//RUS
    }
}
