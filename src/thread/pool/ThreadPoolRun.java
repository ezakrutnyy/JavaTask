package thread.pool;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolRun {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        long startJob = System.currentTimeMillis();


//
//        ExecutorService executor = Executors.newFixedThreadPool(4);
//        for (int i = 100; i > 0; i--) {
//            executor.execute(new GetBucketWorker(i));
//        }
//        executor.shutdown();
//
//
//        while (!executor.isTerminated()) {
//        }


        Collection<Callable<String>> tasks = Lists.newArrayList();
        for (int i = 100; i > 0; i--) {
            tasks.add(new GetBucketWorker(i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(4, new MyThreadCauseFabric());
        List<Future<String>> futures = executor.invokeAll(tasks);
        executor.shutdown();

        Thread thread = new Thread(() -> {
            for (Future<String> future : futures) {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


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
//        System.out.println(String.format("Working %s thread. Getting %d bucket.",
//                Thread.currentThread().getName(), number));
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public String call() throws Exception {
        System.out.println(String.format("Working %s thread. Getting %d bucket.",
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