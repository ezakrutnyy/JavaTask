package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFinder {
    public static void main(String[] args) {
        String inp = "dsdsd.txt asdsadsa sdesadавав вава,,,,...sdsd.docsdsdsdsdsad asdasd .e.x.s s sdsd.exe";
        Pattern pattern = Pattern.compile("\\.[a-z]{3}");
        Matcher matcher = pattern.matcher(inp);

        while(matcher.find()) {
            System.out.println(String.format("Extension %s, start %d, end %d",
                    matcher.group(), matcher.start(), matcher.end()));
        }
    }
}
