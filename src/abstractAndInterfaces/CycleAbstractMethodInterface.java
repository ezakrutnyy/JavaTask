package abstractAndInterfaces;

/**
 * Created by Евгений on 04.05.2018.
 */
public class CycleAbstractMethodInterface {

    public static void consumer(CycleFactory factory) {
        Cycle cycle = factory.getCycleFactory();
        cycle.move();
    }

    public static void main(String[] args) {
        consumer(new UnicycleFactory());
        consumer(new UnicycleFactory());
        consumer(new UnicycleFactory());
    }
}

interface Cycle {
    void move();
}

class Unicycle implements Cycle {

    @Override
    public void move() {
        System.out.println("Перемещаемся на моновелосипеде");
    }
}

class Bicycle implements Cycle {

    @Override
    public void move() {
        System.out.println("Перемещаемся на велосипеде");
    }
}

class Tricycle implements Cycle {
    @Override
    public void move() {
        System.out.println("Перемещаемся на трехколесном велосипеде");
    }
}

interface CycleFactory {
    Cycle getCycleFactory();
}

class UnicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycleFactory() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public Cycle getCycleFactory() {
        return new Bicycle();
    }
}

class TricycleFactory  implements CycleFactory {

    @Override
    public Cycle getCycleFactory() {
        return new Tricycle();
    }
}