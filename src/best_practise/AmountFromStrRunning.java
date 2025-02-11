package best_practise;

public class AmountFromStrRunning {
    public static void main(String[] args) {
        int input = Integer.parseInt("1589");
        int sum = 0;
        while (input > 0) {
            sum += input % 10;
            input /= 10;
        }
        System.out.println(sum);
    }
}