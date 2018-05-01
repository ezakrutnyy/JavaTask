package threads;

/**
 * Created by Евгений on 09.12.2017.
 */
public class JoiningDemo {
    public static void main(String[] args) {

        Thread t1 = new GreetingThread("Child Thread 1");
        Thread t2 = new GreetingThread("Child Thread 2");

        t1.start();
        t2.start();

        try {
            System.out.println("Wait for the child threads to finish.");
            t1.join();
            if (!t1.isAlive())
                System.out.println(t1.getName()+"Thread Child Thread 1 is not alive");
            t2.join();
            if (!t2.isAlive())
                System.out.println("Thread Child Thread 2 is not alive.");
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted.");
        }
        System.out.println("Exit from Main Thread.");
    }

}
