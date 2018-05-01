package objects.blockinit;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Евгений on 24.09.2017.
 */

public class BlockInit {
    static List<Character> abc;
    //статичный блок
    static {
        abc = new LinkedList<Character>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            abc.add( c );
        }
    }

    // нестатичный блок
    {
        System.out.println("Bar: новый экземпляр");
    }

    //Пример инициализации в анонимном классе
    JFrame frame = new JFrame() {{
        add(new JPanel() {{
            add(new JLabel("Хабрахабр?") {{
                setBackground(Color.BLACK);
                setForeground(Color.WHITE);
            }});
        }});
    }};
}