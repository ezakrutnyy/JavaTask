package common;
/**
 * Created by Евгений on 24.07.2017.
 */
public class OrderOnloadClassDemo {
    public static void main(String[] args) {
        //OrderOnloadClass order = new OrderOnloadClass("Merci");
        OrderOnloadChildClass order2 = new OrderOnloadChildClass("Boncy",44);
    }
}

class OrderOnloadClass {


    public OrderOnloadClass(String name) {
        this.name = name;
        System.out.println("constructor parent starting....");

    }


    {
        System.out.println("initianal parent block starting");
        name = "TestName=";
    }

    static {
        System.out.println("static parent block starting");
        id = 1;

    }





    private String name;
    private final static long id;
}


class OrderOnloadChildClass extends OrderOnloadClass{

    public OrderOnloadChildClass(String name,double salary) {
        super(name);
        this.salary = salary;
        System.out.println("constructor child starting....");
    }

    static {
        System.out.println("static child parent block starting");
    }

    {
        System.out.println("initianal child block starting");
        salary = 0;
    }

    private double salary;
}