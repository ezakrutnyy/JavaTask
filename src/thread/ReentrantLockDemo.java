package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {

        Worker worker = new Worker();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.increment();
            }
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();


        System.out.println(worker.getCount());
    }
}


class Worker  {

    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();


    public void increment() {
        lock.lock();
        for (int j = 0; j < 100; j++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        lock.unlock();

    }

    public int getCount() {
        return count;
    }
}
