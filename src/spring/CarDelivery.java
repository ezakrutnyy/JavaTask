package spring;

import org.springframework.stereotype.Component;
import spring.annotations.DeprecatedClass;
import spring.annotations.InjectRandomInt;

@Component
@DeprecatedClass(newImpl = CarDeliveryNewImpl.class)
public class CarDelivery implements Delivery {

    public void init() {
        System.out.println("Phase 2");
        System.out.println("speed = " + speed);
    }

    public CarDelivery() {
        System.out.println("Phase 1");
        System.out.println("speed = " + speed);
    }

    @InjectRandomInt(min = 40, max = 150)
    public int speed;

    @Override
    public void move() {
        System.out.println("Скорость: " + speed);
    }
}
