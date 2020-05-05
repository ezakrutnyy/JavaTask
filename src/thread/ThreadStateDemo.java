package thread;

/**
 * Created by Евгений on 09.12.2017.
 */
public class ThreadStateDemo implements  Runnable{
    Thread thread;

    public void run() {

        Thread.State state = Thread.currentThread().getState();
        String name = Thread.currentThread().getName();

        System.out.println(name + " state is - " + state);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new ThreadStateDemo());
        th.setName("My Thread");

        System.out.println(th.getName() + " state is - " + th.getState());
        th.start();
        Thread.sleep(1000);
        Thread.State state = th.getState();
        System.out.println(th.getName() + " state is - " + state);
    }

}


