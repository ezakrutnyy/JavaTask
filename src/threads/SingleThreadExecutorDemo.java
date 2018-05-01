package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Евгений on 09.12.2017.
 */
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {

        Runnable r1 = new GreetingRunnable("Hello, World!");
        Runnable r2 = new GreetingRunnable("Hi, World!");

        ExecutorService single = Executors.newSingleThreadExecutor();

        single.execute(r1);
        single.execute(r2);

        System.out.println("Single executor launched!");
    }
}
