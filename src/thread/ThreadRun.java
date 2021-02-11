package thread;

public class ThreadRun {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(String.format("Started %s thread!", Thread.currentThread().getName()));

        Thread thread = new Thread(new GreetingThread(), "GreetingThread");
        thread.start();

        Thread thread2 = new Thread(new GreetingThread(), "GreetingThread2");
        thread2.start();

        System.out.println(String.format("Ended %s thread!", Thread.currentThread().getName()));
    }
}


class GreetingThread implements Runnable {

    private static final int REPEAT = 10;

    private static final int DELAY = 10;

    @Override
    public void run() {
        System.out.println(String.format("Started %s thread!", Thread.currentThread().getName()));
        for (int i = REPEAT; i > 0; i--) {
            System.out.println(String.format("Run thread %s - iter %d", Thread.currentThread().getName(), i));
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("Ended %s thread!", Thread.currentThread().getName()));
    }
}