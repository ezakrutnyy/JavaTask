package generics;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public class TypeClass {

    public static void main(String[] args) {

        Phone phone = new Phone("iphone8",new BigDecimal(33000), "4g");
        Phone phone2 = new Phone("iphoneXr",new BigDecimal(80000), "5g");

        Camera camera = new Camera("canon",new BigDecimal(32000),10 );


        Container container1 = new Container(phone);
        Container container2 = new Container(camera);

        List<Container> lst = Lists.newArrayList(container1, container2);

        // container.setItem(new Integer(12)); not compile


        int res = phone.compareTo(phone2);
        System.out.println(res);
    }
}


abstract class Product<T extends Product> implements Comparable<T>{

    String name;

    BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int compareTo(T p) {
        int res =  this.price.compareTo(p.price);
        return res == 0 ? subCompareTo(p) : res;
    }

    public abstract int subCompareTo(T product);
}

class Phone extends Product<Phone> {

    public Phone(String name, BigDecimal price, String typeNetwork) {
        super(name, price);
        this.typeNetwork = typeNetwork;
    }

    String typeNetwork;

    public String getTypeNetwork() {
        return typeNetwork;
    }

    public void setTypeNetwork(String typeNetwork) {
        this.typeNetwork = typeNetwork;
    }


    @Override
    public  int subCompareTo(Phone phone) {
        return this.typeNetwork.compareTo(phone.typeNetwork);
    }

}


class Camera extends Product<Camera>{

    int pixel;

    public int getPixel() {
        return pixel;
    }

    public void setPixel(int pixel) {
        this.pixel = pixel;
    }

    public Camera(String name, BigDecimal price, int pixel) {
        super(name, price);
        this.pixel = pixel;
    }

    @Override
    public int subCompareTo(Camera camera) {
        return this.pixel > camera.pixel ? 1 : -1;
    }


}


class Container<T extends Product> {
    T item;

    public Container(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }


}