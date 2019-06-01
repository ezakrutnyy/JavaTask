package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Евгений on 14.05.2018.
 */
public class ExecutorTryAndCatch {
    public static void main(String[] args) {
        try {
            ExecutorService service  = Executors.newCachedThreadPool(new MyThreadCauseFabric());
            service.execute(new ThreadForTryAndCatch("Tread1"));
            service.shutdown();
        } catch (RuntimeException e) {
            System.out.println("Exception.....");
        }
    }
}

class ThreadForTryAndCatch extends Thread {

    ThreadForTryAndCatch(String thread) {
        super(thread);
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}

class MyThreadCauseFabric implements ThreadFactory {

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyThreadException());
        return t;
    }
}

class MyThreadException implements  Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception description"+e);
    }
}