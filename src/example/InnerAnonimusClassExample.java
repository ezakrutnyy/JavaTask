package example;

public class InnerAnonimusClassExample {
    public static void main(String[] args) {
        MyClass instance = new MyClass() {

            // Compile Error static field in Inner Class
//            public  static int number = 0;
//
//            @Override
//            public void method() { number += 3; }
//            public int getNumber() { return number; }
        };

        instance.method();
        instance.method();
        System.out.println(instance.getNumber()); }
}



class MyClass {

    public void method() {
        System.out.println("Class MyClass: method()");
    }

    public int getNumber() { return 0; }
}
