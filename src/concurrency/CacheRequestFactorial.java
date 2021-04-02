package concurrency;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.concurrent.*;

/*
 * Класс принимает на вход объект запроса Request с параметром N, факториал числа
 * В памяти создаем HashMap.
 * Если в мапе есть расчитанный факториал от числа, возврашаем его.
 * Если нет, то создаем новое значение и кладем в мапу.
 * Программа должны работать в многопоточной среде.
 * */
public class CacheRequestFactorial {
    public static void main(String[] args) throws InterruptedException {
        final List<Request> requests = Lists.newArrayList();
        requests.add(new Request(3));
        requests.add(new Request(6));
        requests.add(new Request(3));
        requests.add(new Request(10));


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CacheFactorial cacheFactorial = new CacheFactorial();

        for (Request request : requests) {
            executorService.execute(() -> cacheFactorial.getFactorial(request.getInput()));
        }

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);

    }

}

class Request {

    private final Integer input;

    public Request(Integer input) {
        this.input = input;
    }

    public Integer getInput() {
        return input;
    }

}

class Repsonce {

    private final Integer input;

    public Repsonce(Integer input) {
        this.input = input;
    }

    public Integer getInput() {
        return input;
    }

}


class CacheFactorial {

    private final ConcurrentMap<Integer, Future<Integer>> result;

    public CacheFactorial() {
        this.result = Maps.newConcurrentMap();
    }

    public Integer getFactorial(Integer num) {
        Future<Integer> future = result.get(num);
        if (future == null) {
            FutureTask<Integer> futureTask = new FutureTask<>(() -> factorial(num));
            future = result.putIfAbsent(num, futureTask);
            if (future == null) {
                System.out.println(Thread.currentThread().getName() + " - Рассчитываем факториал для числа " + num);
                future = futureTask;
                futureTask.run();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " - Уже рассчитан факториал для числа " + num);
        }
        try {
            Integer res = future.get();
            System.out.println(Thread.currentThread().getName() + " - Result " + res);
            return res;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Integer factorial(Integer num) {
        if (num == 0 || num == 1) return 1;

        return num * factorial(num - 1);
    }


}
