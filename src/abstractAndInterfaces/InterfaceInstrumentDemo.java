package abstractAndInterfaces;

/**
 * Created by Евгений on 01.05.2018.
 */
public class InterfaceInstrumentDemo {
    public static void main(String[] args) {

        InstrumentInterface[] arr = new InstrumentInterface[]{new Drams(),new Guitar()};
        for (InstrumentInterface elem : arr) {
            elem.settings();
            elem.play();
        }
    }
}


interface InstrumentInterface {
    String consts = "Константа";
    void play();
    void settings();

}

class Guitar implements InstrumentInterface {

    @Override
    public void play() {
        System.out.println("Играет гитара");
    }

    @Override
    public void settings() {
        System.out.println("Настраиваем гитару");
    }
}

class Drams implements InstrumentInterface {

    @Override
    public void play() {
        System.out.println("Играют барабаны");
    }

    @Override
    public void settings() {
        System.out.println("Настройка барабанов");
    }
}