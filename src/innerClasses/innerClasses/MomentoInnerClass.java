package innerClasses.innerClasses;

/**
 * Created by Евгений on 05.05.2018.
 */
public class MomentoInnerClass {
    public static void main(String[] args) {

        Speedometer2 speedo2 = new Speedometer2();

        speedo2.setSpeed(50);
        speedo2.setSpeed(100);
        System.out.println(speedo2);

        Speedometer2.SpeedometerMemento memento = speedo2.createSpeedometerMemento();

        speedo2.setSpeed(80);
        System.out.println("After setting to 80...");
        System.out.println(speedo2);

        System.out.println("Now restoring state...");
        memento.restoreSpeed();
        System.out.println(speedo2);
    }


}

class Speedometer2 {

    private int speed;
    private int prevSpeed;

    public Speedometer2() {
        this.speed = 0;
        this.prevSpeed = 0;
    }

    void setSpeed(int speed) {
        this.prevSpeed = this.speed;
        this.speed = speed;
    }


    public SpeedometerMemento createSpeedometerMemento() {
        return new SpeedometerMemento();
    }



    public String toString() {
        return "Speedometer [speed=" + speed + ", previousSpeed="
                + prevSpeed + "]";
    }


    public  class SpeedometerMemento {
        private int copyOfSpeed;
        private int copyOfPrevSpeed;

        public int getCopyOfSpeed() {
            return copyOfSpeed;
        }

        public int getCopyOfPrevSpeed() {
            return copyOfPrevSpeed;
        }

        public SpeedometerMemento() {
            copyOfSpeed = speed;
            copyOfPrevSpeed = prevSpeed;
        }

        public void restoreSpeed() {
            speed = copyOfSpeed;
            prevSpeed = copyOfPrevSpeed;
        }
    }
}