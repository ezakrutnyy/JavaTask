package wrapper;

/**
 * Created by Евгений on 17.09.2017.
 */
public class ExampleErrorSlowly1 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (Long i = 0L; i <= 100000000L; i++) {
        }
        time = System.currentTimeMillis() - time;
        System.out.println("It took " + time + " milliseconds to execute this cycle");
    }
}
