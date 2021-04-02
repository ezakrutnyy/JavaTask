package best_practise;

public class FindSecondMinElementArrayRunner {

    public static void main(String[] args) throws Exception {
        /* Поиск 2 го минимального элемента в последовательности
         * 5 1 -3 2 -18 8 10 2 8 4 -1
         * */
        int[] arrays = new int[]{5, 12, 100, 2, -18, 8, 10, 2, 8, 4, 88};
        int secondMinElement = getSecondMinElem(arrays);
        System.out.println("Second min element: " + secondMinElement);

    }

    private static int getSecondMinElem(int[] arrays) throws Exception {
        int firstMinElem = Integer.MAX_VALUE;
        int secondMinElem = Integer.MAX_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < firstMinElem) {
                secondMinElem = firstMinElem;
                firstMinElem = arrays[i];
            } else {
                if (arrays[i] < secondMinElem) secondMinElem = arrays[i];
            }
        }

        if (secondMinElem == Integer.MAX_VALUE) throw new Exception("Second element not found!");

        return secondMinElem;

    }


}
