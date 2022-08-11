package best_practise;

public class FibbonachiRunner {

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144....

    public static void main(String[] args) throws Exception {

        System.out.println(fibSum(7));

        System.out.println(getFibByNumber(10));

        System.out.println(getFibByNumberRecoursive(10));
    }

    private static int getFibByNumberRecoursive(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        return getFibByNumberRecoursive(n - 1) + getFibByNumberRecoursive(n - 2);

    }

    private static int getFibByNumber(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        int firstElem = 1;
        int secondElem = 2;
        while (n-- > 2) {
            int res = firstElem + secondElem;
            firstElem = secondElem;
            secondElem = res;
        }

        return firstElem;
    }

    private static Integer fibSum(int n) throws Exception {
        if (n <= 0) throw new Exception("Not valid n!");

        if (n == 1) return 0;


        int res = 0;
        int firstElem = 0;
        int secondElem = 1;
        while (n-- > 0) {
            res += firstElem;
            int tmp = firstElem + secondElem;
            firstElem = secondElem;
            secondElem = tmp;
        }

        return res;
    }
}
