package thread.old;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Евгений on 09.12.2017.
 */
public class TimerDemo {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();

        TimerTask r = new GreetingTask("Hello, World!");
        timer.schedule(r, 0, 5000);
    }
}


class GreetingTask extends TimerTask {

    private String greeting;

    public GreetingTask(String aGreeting) {
        greeting = aGreeting;
    }

    public void run() {
        System.out.println(greeting);
    }
}
