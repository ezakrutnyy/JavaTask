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
            elem.interfaceMethodElement();
            InstrumentInterface.interfaceMethodStatic();
        }
    }
}


interface InstrumentInterface {
    String consts = "Константа";
    void play();
    void settings();

     static void interfaceMethodStatic() {
         System.out.println("interfaceMethodStatic"+consts);
     }

     default void interfaceMethodElement() {
         System.out.println("interfaceMethodElement"+consts);
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