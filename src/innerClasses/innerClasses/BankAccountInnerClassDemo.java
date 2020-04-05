package innerClasses.innerClasses;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Евгений on 15.07.2017.
 */
public class BankAccountInnerClassDemo {
    public static void main(String[] args) {
        BankAccountInnerClass account = new BankAccountInnerClass(1000);
        account.start(10);
        JOptionPane.showMessageDialog(null, "Выход???");
        System.exit(0);

    }
}


class BankAccountInnerClass {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public BankAccountInnerClass(double balance) {
        this.balance = balance;
    }

    public void start(double rate) {
        ActionListener listen = new InterestAdder(rate);
        Timer t = new Timer(3000,listen);
        t.start();
    }


     private class InterestAdder implements ActionListener {
        private double rate;

        public InterestAdder(double rate) {
            this.rate = rate;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            balance += (balance*rate)/1000;
            System.out.println(balance);
        }
    }
}