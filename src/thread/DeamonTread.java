package thread;

import java.util.concurrent.*;

/**
 * Created by Евгений on 14.05.2018.
 */
public class DeamonTread implements  Runnable{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());
        for (int i = 0; i < 10; i++) {
            executor.execute(new DeamonTread());
        }
        System.out.println("All Daemon started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread() + "" +this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t =  new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
