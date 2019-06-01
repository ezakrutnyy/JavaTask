package guava;

import com.google.common.collect.Range;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created by Евгений on 14.11.2018.
 */
public class RangeDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date start = format.parse("01.11.2018");
        Date end = format.parse("30.11.2018");
        Date date = format.parse("30.11.2018");
        Range range = Range.closed(start,end);
        if (range.apply(date)) {
            System.out.println("Входит");
        }
    }
}
