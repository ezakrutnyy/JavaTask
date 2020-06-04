package datetime;

import org.postgresql.shaded.com.ongres.scram.common.util.Preconditions;

import java.time.*;
import java.util.Date;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        System.out.println("********************Local Time***************************");
        LocalTime localTime = LocalTime.now();
        System.out.println("CurrentTime: "+localTime);

        LocalTime localTimeDefine = LocalTime.of(22, 45, 12);
        System.out.println("localTimeDefine: "+ localTimeDefine);

        LocalTime localTimeDefinePlus = localTimeDefine.plusHours(1).plusMinutes(10).plusSeconds(11);
        System.out.println("localTime Define Plus:" +localTimeDefinePlus);

        LocalTime localTimeDefineMinus = localTimeDefine.minusHours(1).minusMinutes(10).minusSeconds(10);
        System.out.println("localTime Define Minus:" +localTimeDefineMinus);

        System.out.println("********************Change Time***************************");
        /*
         * withHour()
         * withMinute
         * withSecond()
         * withNano()
         * */
        LocalTime localTimeDefineChange = localTimeDefine.withHour(21);
        System.out.println("Change Define Time: "+localTimeDefineChange);

        System.out.println("********************Gets params Date***************************");
        System.out.println("Hour: "+localTimeDefine.getHour());
        System.out.println("Minute: "+localTimeDefine.getMinute());
        System.out.println("Second: "+localTimeDefine.getSecond());
        System.out.println("Nano: "+localTimeDefine.getNano());

        System.out.println("********************Second and Nano Of Day***************************");
        System.out.println("SecondOfDay: "+localTimeDefine.toSecondOfDay());
        System.out.println("NanoOfDay:    "+localTimeDefine.toNanoOfDay());

        System.out.println("********************Local Date Time***************************");
        LocalDate date = LocalDate.of(1988, 7, 9);
        LocalTime time = LocalTime.of(18,30);

        LocalDateTime localDateTimeBirthDay = LocalDateTime.of(date, time);
        System.out.println("Local Date Time BirthDay: "+localDateTimeBirthDay);

        System.out.println();
        System.out.println();
        System.out.println("********************Zone Date Time Creation***************************");
        ZonedDateTime zoneDateTimeBirthDay = localDateTimeBirthDay.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println("ZoneDateTimeBirthDay: "+zoneDateTimeBirthDay);
        System.out.println("ZoneDateTimeBirthDay to Instant: "+zoneDateTimeBirthDay.toInstant());
        System.out.println("ZoneDateTimeBirthDay to Date: "+Date.from(zoneDateTimeBirthDay.toInstant()));

        ZonedDateTime currentZoneDate =  ZonedDateTime.now();
        System.out.println("CurrentZoneDate now: "+currentZoneDate);

        ZonedDateTime defineZoneDate =  ZonedDateTime.of(1961, 4, 12, 14,
                15, 22, 0, ZoneId.systemDefault());
        System.out.println("DefineZoneDate: "+defineZoneDate);

        System.out.println("********************Zone Date Time Plus and Minus and Corrections***************************");
        ZonedDateTime zonedDateTimePlus = currentZoneDate.plusDays(12);
        System.out.println("CurrentZoneDate plus 12 days:" +zonedDateTimePlus);
        ZonedDateTime zonedDateTimeMinus = currentZoneDate.minusWeeks(1);
        System.out.println("CurrentZoneDate minus 1 week:" +zonedDateTimeMinus);

        /*
         * TemporalAmount - реализуется Duration(промежуток) и Period(период)
         * */
        /* если будет переход на летнее время тогда будет неверно! Лучше использовать период*/
        ZonedDateTime nextBirthDay = zoneDateTimeBirthDay.plus(Duration.ofDays(7));
        System.out.println("NextBirthDay by Duration: "+nextBirthDay);

        nextBirthDay = zoneDateTimeBirthDay.plus(Period.ofDays(7));
        System.out.println("NextBirthDay by Period: "+nextBirthDay);

        System.out.println("********************Change Zone Date Time***************************");
        /*
         * withDayOfMonth()
         * withDayOfYear
         * withMonth()
         * withHour()
         * withMinute
         * withSecond()
         * withNano()
         * */
        System.out.println(currentZoneDate.withHour(0).withMinute(0).withSecond(0).withNano(0));

        System.out.println("********************Gets params Zone Date Time***************************");
        System.out.println("DayOfMonth: "+currentZoneDate.getDayOfMonth());
        System.out.println("DayOfYear: "+currentZoneDate.getDayOfYear());
        System.out.println("DayOfWeek: "+currentZoneDate.getDayOfWeek().getValue());
        System.out.println("Year: "+currentZoneDate.getYear());
        System.out.println("Month: "+currentZoneDate.getMonth());
        System.out.println("Hour: "+currentZoneDate.getHour());
        System.out.println("Minute: "+currentZoneDate.getMinute());
        System.out.println("Offset: "+currentZoneDate.getOffset());

        System.out.println("********************Zone Date Time To Other Type***************************");
        LocalDate currentLocaleDate = currentZoneDate.toLocalDate();
        LocalTime currentLocaleTime = currentZoneDate.toLocalTime();
        Instant currentInstant = currentZoneDate.toInstant();
        System.out.println("CurrentLocaleDate: "+currentLocaleDate);
        System.out.println("CurrentLocaleTime: "+currentLocaleTime);
        System.out.println("CurrentInstant: "+currentInstant);
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        Preconditions.checkNotNull(date, "Specified date is null!");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        Preconditions.checkNotNull(localDateTime, "Specified date is null!");
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}