package concurrency.produce_consume;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SendMessage {

    public static void main(String[] args) throws InterruptedException {

        Worker2 worker = new Worker2();

        Thread thread1 = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}


class Worker {

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
        queue.put(random.nextInt(10));
    }
}

    public void consume() throws InterruptedException {

        while (true) {
            System.out.println(queue.take());
            System.out.println("Queue size is " + queue.size());
        }
    }

}

class Worker2 {

    private final Queue<Integer> queue = new LinkedList<>();

    private static final int LIMIT = 5;

    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        final Random random = new Random();

        while (true) {
            synchronized (lock) {
                if (queue.size() == LIMIT) {
                    lock.wait();
                }
                queue.offer(random.nextInt(10));
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                System.out.println("Queue size is " + queue.size());
                if (queue.size() == 0) {
                    lock.wait();
                }
                System.out.println(queue.poll());

                lock.notify();
            }
        }

    }

}

