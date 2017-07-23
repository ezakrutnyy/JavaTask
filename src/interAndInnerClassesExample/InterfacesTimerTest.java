package interAndInnerClassesExample;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Date;

/**
 * Created by Евгений on 15.07.2017.
 */
public class InterfacesTimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(10000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"Выход?");
        System.exit(0);
    }
}

class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("Текущее время ... "+now);
        Toolkit.getDefaultToolkit().beep();
    }
}