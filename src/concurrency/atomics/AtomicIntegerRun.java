package concurrency.atomics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerRun {

    public static void main(String[] args) throws InterruptedException {

        // Посчитаем сумму первых 1000 элементов в многопоточке
        /*
         * Есть еще варианты AtomicBoolean, AtomicLong и AtomicReference
         * */
        AtomicInteger amounter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(() -> {
                    amounter.accumulateAndGet(i, Integer::sum);
                }));
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(amounter.get());


    }
}
