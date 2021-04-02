package concurrency.executors;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Главный поток 1");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Responce::process);
        future.thenAccept(System.out::println);

        System.out.println("Главный поток 2");

        Thread.sleep(3000);

    }
}

class Responce {

    private final static Random random = new Random();


    static Integer process() {
        int res = 0;
        for (int i = 0; i < 1000000; i++) {
            res += random.nextInt(10);
        }
        return res;
    }


}
