package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Евгений on 09.12.2017.
 */
public class ExecutorDemo {
    private static final int MAX_THREADS = 2;

    public static void main(String[] args) {

        Runnable r1 = new GreetingRunnable("Hello, World!");
        Runnable r2 = new GreetingRunnable("Hi, World!");
        ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);

        pool.execute(r1);
        pool.execute(r2);

        pool.shutdown();

        System.out.println("Threadpool created!");
    }

}
