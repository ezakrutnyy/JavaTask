package abstractAndInterfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений on 01.05.2018.
 */
public class AbstractInstrumentDemo {
    public static void main(String[] args) {

        List<Instrument> lst = new ArrayList<Instrument>();
        lst.add(new Accordion());
        lst.add(new Piano());

        for (Instrument i : lst) {
            i.settings();
            i.play();
            System.out.println("Номер: " + i.printInt());
        }

    }
}

abstract class Instrument {
    abstract void play();

    void settings() {
        System.out.println("Настраиваем инструмент");
    }

    abstract int printInt();
}

class Accordion extends Instrument {

    final int i = 0;

    @Override
    void settings() {
        System.out.println("Настраиваем баян");
    }

    @Override
    int printInt() {
        return i;
    }

    @Override
    void play() {
        System.out.println("Играет баян");
    }
}

class Piano extends Instrument {
    final int k = 1;

    @Override
    void play() {
        System.out.println("Играет пианино");
    }

    @Override
    int printInt() {
        return k;
    }
}
