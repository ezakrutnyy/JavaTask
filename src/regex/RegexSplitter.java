package regex;

import java.util.regex.Pattern;

public class RegexSplitter {
    public static void main(String[] args) {

        String inp = "ddsdsd|sdsdsds|sdsdsds|sdsdsds|444";
        Pattern pattern = Pattern.compile("\\|");
        String[] chunks = pattern.split(inp);
        for (String chunk : chunks) {
            System.out.println(chunk);
        }
    }
}
