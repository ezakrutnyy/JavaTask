package interAndInnerClassesExample;

/**
 * Created by Евгений on 23.07.2017.
 */
public class ArrayAlgNestedClassDemo {
    public static void main(String[] args) {
        int[] mas = new int[]{3,-12,10,-4,1,10,33,13,9,0,12};
        ArrayAlgNestedClass.Pair pair = ArrayAlgNestedClass.Pair.minmaxmas(mas);
        System.out.println("min:"+pair.getFirst());
        System.out.println("max:"+pair.getSecond());
    }
}
