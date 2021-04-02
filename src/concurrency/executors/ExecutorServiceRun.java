package concurrency.executors;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceRun {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        long startJob = System.currentTimeMillis();

        /**
         * Async realization execute
         * */
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//        for (int i = 100; i > 0; i--) {
//            executor.execute(new GetBucketWorker(i));
//        }
//        executor.shutdown();
//
//
//        while (!executor.isTerminated()) {
//        }

        /**
         * Async realization with callable
         * */

        ExecutorService executor = Executors.newCachedThreadPool(new MyThreadCauseFabric());
        Random random = new Random();
        List<Future<Integer>> futures = Lists.newArrayList();

        for (int i = 100; i > 0; i--) {
            futures.add(executor.submit(() -> random.nextInt(10)));
        }
        executor.shutdown();

        new Thread(() -> futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        })).start();


        /**
         * Sync realization with callable (throws InterruptedException)
         * */

//        Collection<Callable<String>> tasks = Lists.newArrayList();
//        for (int i = 100; i > 0; i--) {
//            tasks.add(new GetBucketWorker(i));
//        }
//        ExecutorService executor = Executors.newFixedThreadPool(4, new MyThreadCauseFabric());
//        System.out.println("1111");
//        List<Future<String>> futures = executor.invokeAll(tasks);
//        System.out.println("222");
//        executor.shutdown();
//        System.out.println("333");
//
//
//        Thread concurrency = new Thread(() -> {
//            for (Future<String> future : futures) {
//                try {
//                    System.out.println(future.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        concurrency.start();
//

        long endJob = System.currentTimeMillis();
        System.out.println("time: " + (endJob - startJob));
    }
}


class GetBucketWorker implements /*Runnable */ Callable<String> {

    private int number;

    GetBucketWorker(int number) {
        this.number = number;
    }

//    @Override
//    public void run() {
//        System.out.println(String.format("Working %s concurrency. Getting %d bucket.",
//                Thread.currentThread().getName(), number));
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public String call() throws Exception {
        System.out.println(String.format("Working %s concurrency. Getting %d bucket.",
                Thread.currentThread().getName(), number));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return String.valueOf(number);
    }
}


class MyThreadCauseFabric implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyThreadException());
        return t;
    }
}

class MyThreadException implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception description" + e);
    }
}