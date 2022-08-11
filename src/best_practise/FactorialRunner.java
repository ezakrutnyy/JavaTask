package best_practise;

public class FactorialRunner {

    public static void main(String[] args) {
        System.out.println(factorial(1));
    }

    public static int factorial(int num) {
        if (num < 1) return 1;
        return num * factorial(num - 1);

    }
}