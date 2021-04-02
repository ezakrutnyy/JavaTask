package concurrency.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreRunner {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(connection::work);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}


class Connection {

    private final Semaphore semaphore = new Semaphore(5);

    private int connectionCounter;

    public static Connection getConnection() {
        return connection;
    }

    private static Connection connection = new Connection();

    private Connection() {
    }

    void work() {

        try {
            semaphore.acquire();
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() {

        synchronized (this) {
            connectionCounter++;
            System.out.println(connectionCounter);
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connectionCounter--;
        }

    }

}
