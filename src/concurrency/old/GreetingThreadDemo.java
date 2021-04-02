package concurrency.old;

import java.util.Date;

/**
 * Created by Евгений on 09.12.2017.
 */
public class GreetingThreadDemo {
    public static void main(String[] args) {

        GreetingThread r1 = new GreetingThread("Hello, World!");
        GreetingThread r2 = new GreetingThread("Hi, World!");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        System.out.println("Threads started!");
    }

}


class GreetingThread extends Thread {

    private static final int REPETITIONS = 10;
    private static final int DELAY = 1000;

    private String greeting;

    public GreetingThread(String aGreeting) {
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
