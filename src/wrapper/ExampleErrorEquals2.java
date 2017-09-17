package wrapper;

/**
 * Created by Евгений on 17.09.2017.
 */
public class ExampleErrorEquals2 {
    public static void main(String[] args) {
        System.out.println("Compare 50 and 100 : " + compare(50, 100));
        System.out.println("Compare 100 and 50 : " + compare(100, 50));
        System.out.println("Compare 50 and 50 : " + compare(50, 50));
        System.out.println("Compare 200 and 200 : " + compare(200, 200));
    }

    public static int compare(Integer first, Integer second) {
        return first < second ? -1 : (first == second ? 0 : 1);
    }

}
