package concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchRunner {
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executor.execute(new Processor(latch));
        }
        executor.shutdown();

        // будет ждать пока счетчик доконца не доинкрементируется, те не станет равен 0!
        latch.await();

        System.out.println(latch.getCount());
    }
}

class Processor implements Runnable {

    private final CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();

    }
}
