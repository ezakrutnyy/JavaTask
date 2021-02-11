package thread.old;

/**
 * Created by Евгений on 09.12.2017.
 */
public class PrioritiesDemo {
    public static void main(String[] args) {

        Thread t1 = new PriorityGreetingThread("Hello, World!");
        Thread t2 = new PriorityGreetingThread("Yo, World!");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

        System.out.println("Threads started!");
    }
}

class PriorityGreetingThread extends Thread {

    private static final int REPETITIONS = 5;
    private String greeting;

    public PriorityGreetingThread(String aGreeting) {
        this.greeting = aGreeting;
    }

    public void run() {
        for (int i = 1; i <= REPETITIONS; i++) {
            System.out.println(greeting);
        }
    }
}

