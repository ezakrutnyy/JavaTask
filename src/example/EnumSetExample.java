package example;

public class EnumSetExample {

    public static void main(String[] args) {

        At at = new Bt();
        at.mer(34);
    }

}


class At {
    public Number mer(int k)
    { System.out.println("class A, method m : " + ++k); return 12;}

}

class Bt extends At {

    public Number mer(int k) {
        System.out.println("class B, method m : " + k++); return 23;
    }
}
