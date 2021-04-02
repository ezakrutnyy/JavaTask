package concurrency.synchronizers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierRunner {

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        final int[] nums = new int[]{1, 4, 3, 1, 0, -12, 3, 4, 5, 6, 6, 0, 2, 2, 5,};
        Worker worker = new Worker(processors);
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        int step = nums.length / processors;
        int start = 0;
        int end = start + step;
        for (int i = 0; i <= processors; i++) {
            int[] candidate = Arrays.copyOfRange(nums, start, end);
            executor.execute(() -> worker.doWork(candidate));
            start = end;
            end += step;
        }
        executor.shutdown();

    }
}

class Worker {

    private List<Integer> partialResults
            = Collections.synchronizedList(new ArrayList<>());

    private final CyclicBarrier barrier;

    public Worker(int cnt) {
        this.barrier = new CyclicBarrier(cnt, new Aggregate());
    }

    private class Aggregate implements Runnable {
        @Override
        public void run() {
            System.out.println("Reduce()");
            System.out.println("Result count elements %3 = " + partialResults.size());
        }
    }


    public void doWork(int[] nums) {
        System.out.println(Thread.currentThread().getName() + ": Map() Start");
        try {
            System.out.println(Arrays.toString(nums));
            for (int num : nums) {
                if (num != 0 && num % 3 == 0) partialResults.add(num);
            }
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Map() End");
    }
}


