package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Connection connection = Connection.getConnection();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 10; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    connection.work();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
    }


}


class Connection {

    final Semaphore semaphore = new Semaphore(5);

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
