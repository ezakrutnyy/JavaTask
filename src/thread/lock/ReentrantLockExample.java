package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {

        int count = 10;

        final Counter counter = new Counter();
        
        final Thread[] threads = new CounterThread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new CounterThread(counter, 1000);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("COUNTER: "+counter.getValue());

    }



}

class CounterThread extends Thread {

    private final Counter counter;

    private final int count;

    CounterThread(Counter counter, int count) {
        this.counter = counter;
        this.count = count;
    }

    public Counter getCounter() {
        return counter;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            counter.increment();
        }
    }
}

class Counter {

    private long value = 0L;

    private final Lock reentrantLock = new ReentrantLock();

    public void increment() {
        reentrantLock.lock();
        try {
            value++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public long getValue() {
        return value;
    }
}
