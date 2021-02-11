package thread.old;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Главный поток 1");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return AcqResponce.process();
        });

        future.thenAccept(acqResponce -> {
            System.out.println(acqResponce);
        });

        System.out.println("Главный поток 2");

        Thread.sleep(5000);


    }

}



class AcqResponce {


    private String result;

    public String getResult() {
        return result;
    }

    private AcqResponce(String result) {
        this.result = result;
    }

    public static String process()  {
        String s  = "";
        for (int i = 0; i < 30000; i++) {
            s+="1";
        }

        System.out.println(s);

        return  s;
    }


}
