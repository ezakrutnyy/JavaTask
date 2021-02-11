package thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {


    public static void main(String[] args) throws InterruptedException {


        System.out.println(Runtime.getRuntime().availableProcessors());

        Runner runner = new Runner();

        Thread thread1 = new Thread(runner::firstThread);
        Thread thread2 = new Thread(runner::secondThread);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.showResult();
    }

}


class Account {

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;

    public static void transfer(Account account1, Account account2, int amount) {
        account1.setBalance(account1.getBalance() - amount);
        account2.setBalance(account2.getBalance() + amount);
    }
}

class Runner {

    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();

    private Account account1 = new Account(15000);
    private Account account2 = new Account(15000);

    private void takeLocks(ReentrantLock lock1, ReentrantLock lock2) {

        boolean takeLock1 = false;
        boolean takeLock2 = false;

        while (true) {
            try {
                takeLock1 = lock1.tryLock();
                takeLock2 = lock2.tryLock();
            } finally {
                if (takeLock1 && takeLock2) break;

                if (takeLock1) {
                    lock1.unlock();
                }

                if (takeLock2) {
                    lock2.unlock();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(1000));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(1000));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void showResult() {
        System.out.println("Остаток на балансе 1:" + account1.getBalance());
        System.out.println("Остаток на балансе 2:" + account2.getBalance());
        System.out.println("Общая сумма баланса:" + (account1.getBalance() + account2.getBalance()));
    }


}
