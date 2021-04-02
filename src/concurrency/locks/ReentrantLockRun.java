package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRun {

    public static void main(String[] args) throws InterruptedException {

        Worker worker = new Worker();

        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 20000; i++) {
            executor.execute(worker::increment);
        }
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);


        System.out.println(worker.getCount());
    }
}


class Worker {

    private int count = 0;


    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
