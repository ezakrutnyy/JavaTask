package best_practise;

public class AmountFromStrRunning {

    public static void main(String[] args) {
        String input = "1026";
        int number = Integer.valueOf(input);

        int res = 0;
        for (int i = 0; i < input.length(); i++) {
            res += number % 10;
            number /= 10;
        }

        System.out.println(res);

    }
}
