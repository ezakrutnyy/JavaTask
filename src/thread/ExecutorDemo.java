package thread;


import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Евгений on 09.12.2017.
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        Runnable r1 = new GreetingThreadNew("Thread 1");
        Runnable r2 = new GreetingThreadNew("Thread 2");
        Runnable r3 = new GreetingThreadNew("Thread 3");
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);

        pool.shutdown();
        System.out.println("Threadpool created!");
    }

}


class GreetingThreadNew implements Runnable {


    private static final int REPETITIONS = 3;
    private static final int DELAY = 2000;

    private String greeting;

    public GreetingThreadNew(String aGreeting) {
        greeting = aGreeting;
    }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
        } catch (Exception e) {

        }
    }
}
