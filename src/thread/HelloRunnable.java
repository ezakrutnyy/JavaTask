package thread;

/**
 * Created by Евгений on 13.05.2018.
 */
public class HelloRunnable {
    public static void main(String[] args) throws InterruptedException {
        for (int i =0; i<10;i++ ) {
            Thread t1 = new Thread(new MyRunnableClass());
            t1.start();
        }
    }
}

class MyRunnableClass implements  Runnable {
    @Override
    public void run() {
        System.out.println("Запущено новый поток MyRunnableClass ");
    }
}