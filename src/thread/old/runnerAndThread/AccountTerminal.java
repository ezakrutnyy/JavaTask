package thread.old.runnerAndThread;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class AccountTerminal {
    public static void main(String[] args) throws InterruptedException {

        Account account = new Account(new BigDecimal(12000));


        Runnable r1 = new AccountOperationThread(account);
        Runnable r2 = new AccountOperationThread(account);

        Thread tr1 = new Thread(r1, "Thread_1");
        Thread tr2 = new Thread(r2, "Thread_2");

        tr1.start();
        tr2.start();

        tr1.join();
        tr2.join();

        System.out.println(account.getAmount());


    }
}

class AccountOperationThread implements Runnable {

    private Account account;

    private static List<AccountOperation> operations;
    static {
        operations = Lists.newArrayList();
        operations.add(new AccountOperation(new BigDecimal(3000)));
        operations.add(new AccountOperation(new BigDecimal(-7000)));
        operations.add(new AccountOperation(new BigDecimal(-7000)));
        operations.add(new AccountOperation(new BigDecimal(2000)));
        operations.add(new AccountOperation(new BigDecimal(-8000)));
    }

    public AccountOperationThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        Iterator<AccountOperation> iterator = operations.iterator();
        synchronized (account) {
        while (iterator.hasNext()) {

            AccountOperation operation = iterator.next();

                if (account.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(account.getAmount());
                    account.setAmount(account.getAmount().add(operation.getAmount()));
                    System.out.println(" +- "+operation.getAmount());
                    iterator.remove();
                    System.out.println("---------------");
                }
            }
        }

    }
}

class Account {

    BigDecimal amount;

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}


class AccountOperation {
    BigDecimal amount;

    public AccountOperation(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}