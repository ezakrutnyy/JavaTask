package innerClasses;

/**
 * Created by Евгений on 04.05.2018.
 */
public class CycleAbstractMethodInterface {

    public static void consumer(CycleFactory factory) {
        Cycle cycle = factory.getCycleFactory();
        cycle.move();
    }

    public static void main(String[] args) {
        consumer(Unicycle.factory);
        consumer(Bicycle.factory);
        consumer(Tricycle.factory);
    }
}

interface Cycle {
    void move();
}

interface CycleFactory {
    Cycle getCycleFactory();
}

class Unicycle implements Cycle {

    @Override
    public void move() {
        System.out.println("Перемещаемся на моновелосипеде");
    }

    public static CycleFactory factory = new CycleFactory() {
        public Cycle getCycleFactory() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {
    @Override
    public void move() {
        System.out.println("Перемещаемся на велосипеде");
    }

    public static CycleFactory factory = new CycleFactory() {

        public Cycle getCycleFactory() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {
    @Override
    public void move() {
        System.out.println("Перемещаемся на трехколесном велосипеде");
    }

    public static CycleFactory factory = new CycleFactory() {

        public Cycle getCycleFactory() {
            return new Tricycle();
        }
    };
}

