package innerClasses;

/**
 * Created by Евгений on 05.05.2018.
 */
public class MomentoNestedDemo {
    public static void main(String[] args) {
        Speedometer sp = new Speedometer();
        sp.setSpeed(80);
        sp.setSpeed(120);
        System.out.println(sp);

        Object momento = sp.saveToMomento();

        sp.setSpeed(100);

        System.out.println(sp);

        sp.restoreFromMomento(momento);

        System.out.println(sp);

    }

}

class Speedometer {

    private int speed;
    private int prevSpeed;

    public Speedometer() {
        this.speed = 0;
        this.prevSpeed = 0;
    }

    void setSpeed(int speed) {
        this.prevSpeed = this.speed;
        this.speed = speed;
    }

    public Object saveToMomento() {
        System.out.println("Originator: Saving to memento");
        return new SpeedometerMemento(this);
    }

    public void restoreFromMomento(Object speedMomento){
        SpeedometerMemento momento = (SpeedometerMemento) speedMomento;
        this.speed = momento.getCopyOfSpeed();
        this.prevSpeed = momento.getCopyOfPrevSpeed();
    }

    public String toString() {
        return "Speedometer [speed=" + speed + ", previousSpeed="
                + prevSpeed + "]";
    }


    public static class SpeedometerMemento {
        private int copyOfSpeed;
        private int copyOfPrevSpeed;

        public int getCopyOfSpeed() {
            return copyOfSpeed;
        }

        public int getCopyOfPrevSpeed() {
            return copyOfPrevSpeed;
        }

        public SpeedometerMemento(Speedometer s) {
            this.copyOfSpeed = s.speed;
            this.copyOfPrevSpeed = s.prevSpeed;
        }
    }
}