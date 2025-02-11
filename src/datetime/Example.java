package datetime;

import java.time.*;
import java.time.temporal.TemporalAmount;

public class Example {
    public static void main(String[] args) {
        /*
        * [1] Расчитать день программиста, без метода plusDays()
        * */
        LocalDate newYearDay = LocalDate.of(2025, 1,1);
        LocalDate dateIt = newYearDay.plus(Period.ofDays(255));
        System.out.println(dateIt);

        /*
         * [2] нюансы добавления дат на высокосный год
         * */
        LocalDate locDate = LocalDate.of(2000, 2, 29);
        System.out.println("Adding 1 year:"+locDate.plusYears(1));
        System.out.println("Adding 4 years:"+locDate.plusYears(4));
        for (int i = 0; i <=3; i++) {
            locDate = locDate.plusYears(1);
        }
        System.out.println("Adding 4 iterations for 1 year:"+locDate);

        LocalDate locDateDouble = LocalDate.of(2000, 2, 29);
        System.out.println("Adding 1 year by Period:"+locDateDouble.plus(Period.ofYears(1)));
        System.out.println("Adding 4 years by Period:"+locDateDouble.plus(Period.ofYears(4)));
        for (int i = 0; i <=3; i++) {
            locDateDouble = locDateDouble.plus(Period.ofYears(1));
        }
        System.out.println("Adding 4 iterations for 1 year by Period:"+locDateDouble);
    }
}