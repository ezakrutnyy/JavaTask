package concurrency.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinPoolRun {

    public static void main(String[] args) {

        // через fork - join
        long res = new ForkJoinPool().invoke(new Task(0, 1_000_000));
        System.out.println(res);


        // через лямбду
        long res2 = LongStream.range(0, 1_000_000).parallel()
                .filter(i -> i % 3 != 0 && i % 5 != 0).sum();
        System.out.println(res2);

    }


    /* работает как sumbit() + Callable */
    public static class Task extends RecursiveTask<Long> {

        private final int from;

        private final int to;

        public Task(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from < 10_000) {
                return calculate(from, to);
            } else {
                int mid = (from + to) >>> 1;
                Task taskLeft = new Task(from, mid);
                Task taskRight = new Task(mid, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }

        }

        private static long calculate(int rangeFrom, int rangeTo) {
            long res = 0;
            while (rangeFrom++ < rangeTo) {
                if (rangeFrom % 3 != 0 && rangeFrom % 5 != 0) {
                    res += rangeFrom;
                }
            }
            return res;
        }
    }


    /* работает как execute() + Runnable */
//    public static class Task extends RecursiveAction {
//
//        private final int from;
//
//        private final int to;
//
//        public Task(int from, int to, AtomicLong result) {
//            this.from = from;
//            this.to = to;
//            this.result = result;
//        }
//
//        private final AtomicLong result;
//
//        @Override
//        protected void compute() {
//
//            if (to - from < 10_000) {
//                result.addAndGet(calculate(from, to));
//            } else {
//                int mid = (from + to) >>> 1;
//                final Task taskLeft = new Task(from, mid, result);
//                final Task taskRight = new Task(mid, to, result);
//                invokeAll(taskLeft, taskRight);
//            }
//
//        }
//
//        private static long calculate(int rangeFrom, int rangeTo) {
//            long res = 0;
//            while (rangeFrom++ < rangeTo) {
//                if (rangeFrom % 3 != 0 && rangeFrom % 5 != 0) {
//                    res += rangeFrom;
//                }
//            }
//            return res;
//        }
//    }


}

