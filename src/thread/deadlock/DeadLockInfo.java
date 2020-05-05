package thread.deadlock;

public class DeadLockInfo {

    public static void main(String[] args) {
        Thread info = new InfoThread();
        Thread update = new UpdateThread();
        info.start();
        update.start();
    }
}

class InfoThread extends Thread {
    @Override
    public void run() {
        synchronized(InfoThread.class) {
            System.out.println("InfoThread: Hold InfoThread!");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("InfoThread: Waiting UpdateThread!");
            synchronized(UpdateThread.class) {
                System.out.println("InfoThread: Hold UpdateThread!");
            }
        }
    }
}

class UpdateThread extends Thread {
    @Override
    public void run() {
        synchronized(UpdateThread.class) {
            System.out.println("UpdateThread: Hold UpdateThread!");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("UpdateThread: Waiting InfoThread!");
            synchronized(InfoThread.class) {
                System.out.println("UpdateThread: Hold InfoThread!");
            }
        }
    }
}
