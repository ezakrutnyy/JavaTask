package datetime;

import org.postgresql.shaded.com.ongres.scram.common.util.Preconditions;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

public class LocalDateDemo {
    public static void main(String[] args) {

        System.out.println("********************Creation***************************");
        LocalDate localDate = LocalDate.now();
        System.out.println("CurrentDate: "+localDate);

        LocalDate birthDay = LocalDate.of(1988, 7, 9);
        System.out.println("BirthDay: "+birthDay);

        System.out.println("********************AddDays and MinusDays***************************");

        LocalDate birthDayPlus = birthDay.plusDays(10).plusMonths(3).plusYears(12);
        System.out.println("Plus BirthDay: "+birthDayPlus);

        LocalDate birthDayMinus = birthDay.minusDays(10).minusMonths(3).minusYears(12);
        System.out.println("Minus BirthDay: "+birthDayMinus);

        System.out.println("********************Change Date***************************");
        /*
         * withDayOfMonth()
         * withDayOfYear
         * withMonth()
         * */
        LocalDate birthDayChange = birthDay.withYear(1988).withMonth(7).withDayOfMonth(9);
        System.out.println("Change Birth Day: "+birthDayChange);

        System.out.println("********************Diff dates***************************");
        System.out.println("Diff until: "+birthDay.until(localDate,  ChronoUnit.DAYS));

        System.out.println("********************Period***************************");
        Period period = Period.between(birthDay, localDate);
        System.out.println("Period diff days: "+period.getDays());
        System.out.println("Period diff months: "+period.getMonths());
        System.out.println("Period diff years: "+period.getYears());

        System.out.println("********************datesUntil()***************************");
        /* TODO работает для JAVA 9 */
        //Stream<LocalDate> dates = birthDay.datesUntil(birthDayChange);
        System.out.println("********************Gets params local Date***************************");
        System.out.println("DayOfMonth: "+birthDay.getDayOfMonth());
        System.out.println("DayOfYear: "+birthDay.getDayOfYear());
        System.out.println("DayOfWeak: "+birthDay.getDayOfWeek().getValue());
        System.out.println("Month: "+birthDay.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH));
        System.out.println("Month value: "+birthDay.getMonthValue());
        System.out.println("Year: "+birthDay.getYear());

        System.out.println("********************Temporal Adjusters***************************");

        System.out.println("First Day Of Month:"+birthDay.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("First Day Of Next Month:"+birthDay.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("First Day Of Year:"+birthDay.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("First Day Of Next Year:"+birthDay.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println("First In Month SATURDAY:"+birthDay.with(TemporalAdjusters.firstInMonth(DayOfWeek.SATURDAY)));

        System.out.println("Last Day Of Month:"+birthDay.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Last Day Of Year:"+birthDay.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("Last In Month SATURDAY:"+birthDay.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY)));

        System.out.println("Next Or Same SATURDAY:"+birthDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));
        System.out.println("Next SATURDAY:"+birthDay.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

        System.out.println("Previous Or Same SATURDAY:"+birthDay.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY)));
        System.out.println("Previous SATURDAY:"+birthDay.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));

        /* собственный корректор даты
         * Следующий рабочий день
         * */
        TemporalAdjuster NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster(date -> {
            do {
                date = date.plusDays(1);
            } while (date.getDayOfWeek().getValue()>5);
            return date;
        });

        System.out.println("BACK TO WORK: "+birthDay.with(NEXT_WORKDAY));

        System.out.println("********************Diff dates***************************");
        LocalDate afterDate = LocalDate.of(2016, 12, 3);
        LocalDate beforeDate = LocalDate.of(2014, 7,14);
        if (beforeDate.isBefore(afterDate)) {
            System.out.println("BeforeDate before AfterDate:");
        }

        System.out.println("******************** Convert Date To LocalDate ***************************");
        // Convert Date To LocalDate
        LocalDate convertLocalDate = convertDateToLocalDate(new Date());
        System.out.println(convertLocalDate);
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        Preconditions.checkNotNull(date, "Specified date is null!");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        Preconditions.checkNotNull(localDate, "Specified date is null!");
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}