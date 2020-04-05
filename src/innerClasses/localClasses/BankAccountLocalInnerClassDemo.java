package innerClasses.localClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Евгений on 23.07.2017.
 */
public class BankAccountLocalInnerClassDemo {
    public static void main(String[] args) {
        BankAccountLocalInnerClass account = new BankAccountLocalInnerClass(1000);
        account.start(10);
        JOptionPane.showMessageDialog(null, "Выход???");
        System.exit(0);
    }
}

class BankAccountLocalInnerClass {

    private double balance;
    BankAccountLocalInnerClass(double balance) {
        this.balance = balance;
    }

    public void start(final double rate) {
        class InterestAdder implements   ActionListener {
            public void actionPerformed(ActionEvent e) {
                balance += (balance*rate)/1000;
                System.out.println(balance);
            }
        }
        ActionListener listen = new InterestAdder();
        Timer t = new Timer(3000,listen);
        t.start();
    }

}

