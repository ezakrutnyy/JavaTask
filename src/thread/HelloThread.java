package thread;

import java.util.ArrayList;

/**
 * Created by Евгений on 13.05.2018.
 */
public class HelloThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thr = new MyThreadClass();
            thr.start();
            thr.join();
        }
    }
}

class MyThreadClass extends  Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}