package concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceRun {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // каждые 3 секунды, не считая времени выполнения задачи
        executor.scheduleAtFixedRate(() -> System.out.println("Hello..." + Thread.currentThread().getName()), 0, 3, TimeUnit.SECONDS);
        // каждую 1 секунду, после завершения исполняемой задачи
        executor.scheduleWithFixedDelay(() -> System.out.println("Bye..." + Thread.currentThread().getName()), 0, 1, TimeUnit.SECONDS);
    }
}
