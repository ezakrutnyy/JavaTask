package parsers;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Dates {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static String convertDateToStr(Date date) {

        if (Objects.isNull(date))
            return StringUtils.EMPTY;

        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static Date convertStrToDate(String date) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(date);
    }
}
