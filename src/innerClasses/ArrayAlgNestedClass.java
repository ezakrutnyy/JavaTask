package innerClasses;

/**
 * Created by Евгений on 23.07.2017.
 */
public class ArrayAlgNestedClass {
    public static class Pair {

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public static Pair minmaxmas(int[] mas) {
            if (mas.length==0) return new Pair(0,0);
            int min = mas[0];
            int max = mas[0];
            for (int i = 1; i < mas.length; i++) {
                if (min>mas[i]) min = mas[i];
                if (max<mas[i]) max = mas[i];
            }
            return new Pair(min,max);
        }
        private int first;
        private int second;

    }

    public static void main(String[] args) {
        int[] mas = new int[]{3,-12,10,-4,1,10,33,13,9,0,12};
        Pair pair = Pair.minmaxmas(mas);
        System.out.println("min:"+pair.getFirst());
        System.out.println("max:"+pair.getSecond());
    }
}
