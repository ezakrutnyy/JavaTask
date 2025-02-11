package datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Instant.Min: " + Instant.MIN);
        System.out.println("Instant.Max: " + Instant.MAX);
        Instant instant = Instant.now();
        System.out.println("Instant.Current: " + instant);

        /* Разница между Instants */
        Instant start = Instant.now();
        runAlgorithmFast();
        Instant end = Instant.now();
        end = end.plusMillis(1000);
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("TimeElapsed: " + timeElapsed.toMillis());

        /* Операции над промежутками */
        timeElapsed = timeElapsed.plusDays(1);
        System.out.println("TimeElapsed + 1 days: " + timeElapsed.toMillis());

        /* проверка быстроты одного алгоритма над другим*/
        Instant start1 = Instant.now();
        runAlgorithmFast();
        Instant end1 = Instant.now();
        Duration timeElapsed1 = Duration.between(start1, end1);

        Instant start2 = Instant.now();
        runAlgorithmSlow();
        Instant end2 = Instant.now();
        Duration timeElapsed2 = Duration.between(start2, end2);

        boolean overThreeTimesFaster = timeElapsed1.multipliedBy(3)
                .minus(timeElapsed2).isNegative();
        System.out.println("overThreeTimesFaster: " + overThreeTimesFaster);
    }

    public static void runAlgorithmFast() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void runAlgorithmSlow() throws InterruptedException {
        Thread.sleep(8000);
    }
}