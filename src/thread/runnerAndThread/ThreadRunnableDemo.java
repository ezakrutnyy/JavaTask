package thread.runnerAndThread;

import java.util.Date;

/**
 * Created by Евгений on 09.12.2017.
 */
public class ThreadRunnableDemo {
    public static void main(String[] args) {
        Runnable r1 = new SimpleThread("Hello, World!");
        Runnable r2 = new SimpleThread("Bye!");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);


        System.out.println(t1.isAlive());

        t1.start();
        t2.start();

        System.out.println(t1.isAlive());

        System.out.println("Threads started!");
    }
}

class SimpleThread implements Runnable {

    private static final int REPETITIONS = 5;
    private static final int DELAY = 1000;

    private String greeting;

    public SimpleThread(String aGreeting) {
        greeting = aGreeting;
    }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException exception) {
        }
    }
}