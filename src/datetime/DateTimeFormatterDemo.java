package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {

        System.out.println("*************format()**************");
        /*
         * [1] Standart View
         * */
        ZonedDateTime zDate = ZonedDateTime.now();
        String formatter = DateTimeFormatter.ISO_DATE_TIME.format(zDate);
        String formatterEmail = DateTimeFormatter.RFC_1123_DATE_TIME.format(zDate);
        System.out.println("ISO_DATE_TIME: " + formatter);
        System.out.println("RFC_1123_DATE_TIME: " + formatterEmail);

        /*
         * [2] Regional Config
         * */
        DateTimeFormatter formatterRegionFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter formatterRegionLong = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter formatterRegionMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatterRegionShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println("Formatter Default Region FULL: " + formatterRegionFull.format(zDate));
        System.out.println("Formatter Default Region LONG: " + formatterRegionLong.format(zDate));
        System.out.println("Formatter Default Region MEDIUM: " + formatterRegionMedium.format(zDate));
        System.out.println("Formatter Default Region SHORT: " + formatterRegionShort.format(zDate));

        DateTimeFormatter formatterFrenchRegionFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.FRENCH);
        System.out.println("Formatter French Region FULL: " + formatterFrenchRegionFull.format(zDate));

        /*
         * [3] On own pattern
         * yy:69 yyyy:1969
         * M:7 MM:07 MMM:Jul MMMM:July MMMMM:J
         * d:6 dd:06
         * e:3 E:Wed EEEE:Wednesday EEEEE:W
         * H:9 HH:09
         * K:9 KK:09
         * a:AM
         * mm:02
         * ss:00
         * nnnnnn:000000
         * VV:America/New_York
         * z:EDT zzzz:Eastern Dayling Time
         * x:-04 xx:-0400 xxx:-04:00
         * O:GMT-4 OOOO:GMT-04:00
         * */
        DateTimeFormatter ownPattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ssx");
        System.out.println("Own pattern: " + ownPattern.format(zDate));

        System.out.println("*************parse()**************");
        String charsPattern = "09.07.1988 18:34:33+03";
        LocalDate localDate = LocalDate.from(ownPattern.parse(charsPattern));
        System.out.println("LocalDate parse():" + localDate);
        LocalTime localTime = LocalTime.from(ownPattern.parse(charsPattern));
        System.out.println("LocalTime parse():" + localTime);

        ZonedDateTime zDateNew = ZonedDateTime.parse(charsPattern, ownPattern);
        System.out.println("ZonedDateTime parse: " + zDateNew);

        System.out.println("*************Instant -> Date **************");
        Date date = Date.from(zDate.toInstant());
        System.out.println(date);

        System.out.println("*************Date -> Instant **************");
        Instant inst = date.toInstant();
        System.out.println(inst);

        /*
         * Есть методы для взаимодействия с GregorianCalendar -> ZoneDateTime
         * */
        GregorianCalendar calendar = GregorianCalendar.from(zDateNew);
        System.out.println("*************ZoneDateTime -> GregorianCalendar **************");
        System.out.println(calendar);
        System.out.println("*************GregorianCalendar -> ZoneDateTime **************");
        System.out.println(calendar.toZonedDateTime());
    }
}