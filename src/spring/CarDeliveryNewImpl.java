package spring;

public class CarDeliveryNewImpl extends CarDelivery {

    @Override
    public void move() {
        System.out.println("Новая служба доставка: + 7 999 222 12 12");
        super.move();
        System.out.println("Ждемс....");
    }
}
