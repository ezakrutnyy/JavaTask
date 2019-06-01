package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Евгений on 15.08.2017.
 */
public class CalendarDemo {
    public static void main(String[] args) throws InterruptedException {

        // Получение времени через currentTimeMillis
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");
        long currentTime = System.currentTimeMillis();
        System.out.println(format.format(currentTime));


        //Логирование времени
        long startTime = System.currentTimeMillis();
        sleepMethod();
        long endTime = System.currentTimeMillis();
        System.out.println("Прошло - "+(endTime-startTime)/1000 + " seconds");

        // Объект Date
        Date firstTime = new Date();
        System.out.println(format.format(firstTime));

        //Календари
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.printf("Год %d, месяц %d, день %d",year,month+1,dayOfMonth);

        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);
        System.out.println();
        System.out.printf("час %d, минута %d, секунда %d, миллисекунда %d",hourOfDay,minute,second, millisecond);
        System.out.println();

        //Задание даты и времени set()
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 9);
        System.out.println(format.format(cal.getTime()));

        //Увелечение даты add()
        cal.add(Calendar.YEAR,29);
        cal.add(Calendar.DAY_OF_MONTH, -167);
        System.out.println(format.format(cal.getTime()));

        //прокрутка параметра календаря roll()
        cal.roll(Calendar.MONTH,13);
        System.out.println(format.format(cal.getTime()));

    }

    public static void sleepMethod() throws InterruptedException {
        for(int i=0;i<3;i++) {
            System.out.println("sleepMethod "+(i+1));
            Thread.sleep(1000);
        }
    }
}