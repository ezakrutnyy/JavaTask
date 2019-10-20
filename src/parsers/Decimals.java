package parsers;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Objects;

public class Decimals {

    private final static DecimalFormat decimalFormat;

    static {
        String pattern = "#,##0.00";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
    }

    public static BigDecimal convertStrToDecimal(String str) throws ParseException {
        return (BigDecimal) decimalFormat.parse(str);

    }


    public static String convertDecimalToStr(BigDecimal amount) {
        return Objects.isNull(amount) ? StringUtils.EMPTY : decimalFormat.format(amount);

    }


}
