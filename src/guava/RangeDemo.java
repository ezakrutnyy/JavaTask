package guava;

import com.google.common.collect.Range;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 14.11.2018.
 */
public class RangeDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date start = format.parse("01.11.2018");
        Date end = format.parse("30.11.2018");
        Date date = format.parse("30.11.2018");
        Range<Date> range = Range.closed(start, end);
        if (range.contains(date)) {
            System.out.println("Входит");
        }
    }
}
