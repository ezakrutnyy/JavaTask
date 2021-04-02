package generics;

import java.math.BigDecimal;

public class TypeClass {

    public static void main(String[] args) {

        Phone phone = new Phone("iphone8", new BigDecimal(33000), "4g");
        Phone phone2 = new Phone("iphoneXr", new BigDecimal(80000), "5g");

        Camera camera1 = new Camera("canon", new BigDecimal(32000), 10);
        Camera camera2 = new Camera("canon", new BigDecimal(32000), 10);

        int res = phone.compareTo(phone2);
        int res2 = camera1.compareTo(camera2);
        System.out.println(res);
        System.out.println(res2);
    }
}


abstract class Product<T extends Product> implements Comparable<T> {

    private String name;

    BigDecimal price;

    Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(T p) {
        int res = this.price.compareTo(p.price);
        return res == 0 ? subCompareTo(p) : res;
    }

    public abstract int subCompareTo(T product);
}

class Phone extends Product<Phone> {

    Phone(String name, BigDecimal price, String typeNetwork) {
        super(name, price);
        this.typeNetwork = typeNetwork;
    }

    private String typeNetwork;

    @Override
    public int subCompareTo(Phone phone) {
        return this.typeNetwork.compareTo(phone.typeNetwork);
    }

}


class Camera extends Product<Camera> {

    private int pixel;


    Camera(String name, BigDecimal price, int pixel) {
        super(name, price);
        this.pixel = pixel;
    }

    @Override
    public int subCompareTo(Camera camera) {
        return this.pixel > camera.pixel ? 1 : -1;
    }


}