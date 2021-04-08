package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarDeliveryRunner {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean(Delivery.class).move();
    }
}
