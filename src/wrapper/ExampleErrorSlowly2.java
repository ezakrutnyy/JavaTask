package wrapper;

/**
 * Created by Евгений on 17.09.2017.
 */
public class ExampleErrorSlowly2 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= 100000000L; i++) {
            sum += i;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
        System.out.println("Sum is: " + sum);
    }
}