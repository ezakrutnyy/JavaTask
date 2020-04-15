package example;

class A {
}

interface  I{

}

class B extends A implements I {

}


public class InterfaceExample {

    static void foo(A a) {
        System.out.println("Class A ");
    }

    static void foo(B b) {
        System.out.println("Class B ");
    }

    static void foo(I i) {
        System.out.println("I");
    }


    public static void main(String[] args) {
        A a = new B();
        InterfaceExample.foo(a);
        InterfaceExample.foo((B) a);
        InterfaceExample.foo((I) a);
    }
}
