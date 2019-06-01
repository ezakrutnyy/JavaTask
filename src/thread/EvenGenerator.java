package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Евгений on 14.05.2018.
 */


public class EvenGenerator extends  IntGenerator {
    private int currentEvenNumber = 0;

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

    @Override
    public  synchronized int next() {
        ++currentEvenNumber;
        Thread.yield();
        ++currentEvenNumber;
        return currentEvenNumber;
    }
}

class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while(!generator.isCanceled()) {
            int val = generator.next();
            if (val%2!=0) {
                System.out.println("value not even "+val);
                generator.cancel();

            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press c - to exit ");

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i =0; i < count; i++) {
            service.execute(new EvenChecker(generator, i));
        }
        service.shutdown();

    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}

abstract class IntGenerator {
    private volatile  boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}

