package concurrency.executors;

import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BulkUploadProcessor {

    public static void main(String[] args) {

        final List<Tracking> trackingList = Lists.newArrayList();
        trackingList.add(new Tracking(1L, "aof.test:9090/trackingId=1"));
        trackingList.add(new Tracking(2L, "aof.test:9090/trackingId=2"));
        trackingList.add(new Tracking(3L, "aof.test:9090/trackingId=3"));
        trackingList.add(new Tracking(4L, "aof.test:9090/trackingId=4"));
        trackingList.add(new Tracking(5L, "aof.test:9090/trackingId=5"));
        trackingList.add(new Tracking(6L, "aof.test:9090/trackingId=6"));
        trackingList.add(new Tracking(7L, "aof.test:9090/trackingId=7"));
        trackingList.add(new Tracking(8L, "aof.test:9090/trackingId=8"));
        trackingList.add(new Tracking(9L, "aof.test:9090/trackingId=9"));
        trackingList.add(new Tracking(10L, "aof.test:9090/trackingId=10"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Logic logic = new Logic();
        for (Tracking tracking : trackingList) {
            CompletableFuture.supplyAsync(logic::startFunds, executorService)
                    .thenAccept(response -> {} /*restApi(tracking.getTrackingId(), tracking.getCallbackUrl())*/);
        }
        executorService.shutdown();

    }
}

class Response {

    private final Status status;

    public Response(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}

enum Status {
    OK,
    FAILED
}

class Logic {

    public Response startFunds() {
        System.out.printf("[%s] execute startFunds%n", Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Response(Status.OK);
    }
}

class Tracking {

    private final String callbackUrl;

    private final Long trackingId;

    public Tracking(Long trackingId, String callbackUrl) {
        this.callbackUrl = callbackUrl;
        this.trackingId = trackingId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public Long getTrackingId() {
        return trackingId;
    }
}