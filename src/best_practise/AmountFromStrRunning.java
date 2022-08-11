package best_practise;

public class AmountFromStrRunning {

    public static void main(String[] args) {
        final String input = "1026";
        int number = Integer.valueOf(input);

        int res = 0;
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        System.out.println(res);

    }
}
