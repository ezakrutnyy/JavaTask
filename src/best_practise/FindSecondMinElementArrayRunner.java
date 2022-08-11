package best_practise;

public class FindSecondMinElementArrayRunner {

    public static void main(String[] args) throws Exception {
        /* Поиск 2 го минимального элемента в последовательности
         * 5, 12, 100, -1, -18, 8, 10, 2, 8, 4, 88
         * */
        int[] arrays = new int[]{5, 12, 100, -1, -18, 8, 10, 2, 8, 4, 88};
        int secondMinElement = getSecondMinElem(arrays);
        System.out.println("Second min element: " + secondMinElement);

    }

    private static int getSecondMinElem(int[] arrays) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int candidate : arrays) {
            if (second > candidate) {
                if (first > candidate) {
                    second = first;
                    first = candidate;
                } else {
                    second = candidate;
                }
            }
        }
        return second;
    }
}
