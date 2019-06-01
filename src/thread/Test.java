package thread;


import java.util.Arrays;

/**
 * Created by Евгений on 20.05.2018.
 */
public class Test {
    public static void main(String[] args) {
        int prev = 1;
        int next = 1;
        int sum = 2;
        int n = 5;
        System.out.print(prev+ " "+next);

        for (int i = 2; i<n; i++) {
            int add = prev + next;
            prev  = next;
            next = add;
            System.out.print(" "+ next);
            sum += next;
        }
        System.out.println();
        System.out.println("Сумма равна "+sum);


        System.out.println(fib(6));
    }


    static int fib(int i) {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fib(i-2)+fib(i-1);
    }
}