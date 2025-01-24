package bigdecimal;

import java.io.IOException;

/**
 * Created by Евгений on 05.09.2017.
 */
public class BigDecimalDemo {

    private static final String LEFT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK_SYMBOL = "\u00AB";

    private static final String RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK_SYMBOL = "\u00BB";

    private static final String NO_BRACE_SPACE_SYMBOL = "\u00a0";

    private static final String EN_DASH_SYMBOL = "\u2013";

    private static final String EM_DASH_SYMBOL = "\u2014";

    public static void main(String[] args) {



        String srcStr = "«Привет мир—труд–май»";

        String srcStr2 = srcStr
                .replace(LEFT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK_SYMBOL, "\"")
                .replace(RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION_MARK_SYMBOL, "\"")
                .replace(NO_BRACE_SPACE_SYMBOL," ")
                .replace(EN_DASH_SYMBOL,"-")
                .replace(EM_DASH_SYMBOL,"--");

        char[] cs = srcStr.toCharArray();
        for (int i = 0; i < srcStr.length(); ++i) {
            int cp866;
            int unicode;
            try {
                byte[] bts = srcStr.substring(i, i + 1).getBytes("cp866");
                if (bts.length != 1) {
                    System.out.println("false");
                }
                cp866 = bts[0] & 0xff;
                unicode = srcStr.codePointAt(i);

                if (cp866 == 63 && (unicode == 171 || unicode == 187 || unicode == 8211 || unicode == 8212)) {
                    cs[i] = '"';
                }

                if (cp866 == 255) {
                    cs[i] = 'Ж';
                }
            } catch (IOException ioe) {
                System.out.println("false");
            }

        }
        System.out.println(srcStr2);
    }
}
