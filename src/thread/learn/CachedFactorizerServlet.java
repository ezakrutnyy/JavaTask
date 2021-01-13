package thread.learn;

/*
 * Сервлет который кеширует свой последний запрос и результат
 * */

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ThreadSafe
public class CachedFactorizerServlet {

    public static void main(String[] args) throws InterruptedException {

        final CachedFactorizerServlet cachedFactorizerServlet = new CachedFactorizerServlet();

//        Thread[] tasks = new Thread[10];
//        for (int i = 0; i < tasks.length; i++) {
//            tasks[i] = new Thread(() -> cachedFactorizerServlet.service(new Request(new Random().nextInt(5))));
//        }
//        for (Thread task : tasks) {
//            task.start();
//        }

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> cachedFactorizerServlet.service(new Request(new Random().nextInt(5))));
        }
        executor.shutdown();


        TimeUnit.SECONDS.sleep(5);
        System.out.println("---------------------------------");
        System.out.println(cachedFactorizerServlet.getHits());
        System.out.println(cachedFactorizerServlet.getHashHits());

    }

    @GuardedBy("this") private long hits;

    @GuardedBy("this") private long hashHits;

    @GuardedBy("this") private Integer lastNumber;

    @GuardedBy("this") private Integer lastFactorial;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized long getHashHits() {
        return hashHits;
    }

    public void service(Request request) {
        Integer i = request.getI();
        Integer factorial = null;
        synchronized(this) {
            hits++;
            if (i.equals(lastNumber)) {
                hashHits++;
                factorial = lastFactorial;
                System.out.println(Thread.currentThread().getName());
                System.out.println("i = " + i + " factorial from cache = " + factorial);
            }
        }

        if (factorial == null) {
            factorial = factorial(i);
            synchronized(this) {
                lastNumber = i;
                lastFactorial = factorial;
                System.out.println(Thread.currentThread().getName());
                System.out.println("i = " + i + " factorial = " + factorial);
            }
        }
    }

    private Integer factorial(Integer i) {
        if (i == 0) return 1;

        return i * factorial(i - 1);
    }
}


class Request {

    Integer i;

    public Request(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}

class Respance {

}