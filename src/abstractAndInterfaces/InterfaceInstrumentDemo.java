package abstractAndInterfaces;

/**
 * Created by Евгений on 01.05.2018.
 */
public class InterfaceInstrumentDemo {
    public static void main(String[] args) {
        InstrumentInterface[] arr = new InstrumentInterface[]{new Drams(), new Guitar()};
        for (InstrumentInterface obj : arr) {
            obj.settings();
            obj.play();
            obj.interfaceMethodElement();
            InstrumentInterface.interfaceMethodStatic();
        }
    }
}

interface InstrumentInterface {

    String CONSTANT = "Константа";

    void play();

    void settings();

    static void interfaceMethodStatic() {
        System.out.println("interfaceMethodStatic " + CONSTANT);
    }

    static void interfaceMethodStatic2() {
        interfaceMethodStatic();
    }

    default void interfaceMethodElement() {
        System.out.println("interfaceMethodElement " + CONSTANT);
    }

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

    @Override
    public void interfaceMethodElement() {
        System.out.println("interfaceMethodElement in Guitar" + CONSTANT);
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