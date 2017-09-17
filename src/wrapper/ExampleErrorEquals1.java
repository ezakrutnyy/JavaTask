package wrapper;

/**
 * Created by Евгений on 17.09.2017.
 */
public class ExampleErrorEquals1 {
    public static void main(String[] args) {
        Integer i = 127;
        Integer j = 127;
        System.out.println("i==j >> " + (i == j));

        Integer a = 127;
        Integer b = new Integer(127);
        System.out.println("a==b >> " + (a == b));

        Integer k = 128;
        Integer l = 128;
        System.out.println("k==l >> " + (k == l));
    }
}
