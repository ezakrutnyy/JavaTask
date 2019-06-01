package innerClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Евгений on 23.07.2017.
 */
public class BankAccountAnonimClassDemo {
    public static void main(String[] args) {
        BankAccountInnerClass account = new BankAccountInnerClass(1000);
        account.start(10);
        JOptionPane.showMessageDialog(null, "Выход???");
        System.exit(0);
    }
}

class BankAccountAnonimClass {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public BankAccountAnonimClass(double balance) {
        this.balance = balance;
    }

    public void start(final double rate) {
        ActionListener listen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            balance += (balance*rate)/1000;
            System.out.println(balance);
            }
        };
        Timer t = new Timer(3000,listen);
        t.start();
    }
}
