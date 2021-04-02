package best_practise;

public class BinarySearch {

    // -3 2 1 0 -10 5 12
    // -10 -3 0 1 2 5 12
    public static void main(String[] args) {

        int[] array = new int[]{-3, 2, 1, 0, -10, 5, 12};
        BubleSort.bubleSort(array);
        int index = binarySearch(1, array, 0, array.length - 1);
        System.out.println(index);

    }

    private static int binarySearch(int search, int[] array, int from, int to) {

        if (to >= from) {

            // ищем середину массива
            int mid = (from + to) / 2;

            if (search == array[mid]) return mid;

            return search < array[mid] ? binarySearch(search, array, from, mid -1) :
                    binarySearch(search, array, mid + 1, to);
        }

        return -1;

    }


}
