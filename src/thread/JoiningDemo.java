package thread;

/**
 * Created by Евгений on 14.05.2018.
 */
public class JoiningDemo {
    public static void main(String[] args) {
        Sleeping sleeper1 = new Sleeping("Sleep1", 3000),
                sleeper2 = new Sleeping("Sleep2", 3000);
        Joining joining1 = new Joining("Join1",sleeper1),
                joining2 = new Joining("Join2",sleeper2);

        sleeper1.interrupt();

    }
}

class Sleeping extends Thread {

    private int duration;
    Sleeping(String name, int sleepTime) {
        super(name);
        this.duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() +" was interrupted "+ isInterrupted());
            return;
        }
        System.out.println(getName()+" has awakend");
    }
}

class Joining extends Thread {
    private Sleeping sleeping;
    Joining(String name, Sleeping sleeping) {
        super(name);
        this.sleeping = sleeping;
        start();
    }

    @Override
    public void run() {
        try {
            sleeping.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+" join competed");
    }
}