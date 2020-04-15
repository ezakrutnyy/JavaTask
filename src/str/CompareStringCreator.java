package str;

public class CompareStringCreator {
    public static void main(String[] args) {

        String w1 = "One apple";

//        String compareStr = "";
//        long start1 = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            compareStr += w1;
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("String by +, time: "+(end1-start1));

        String compareStr2 = "";
        long start2 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            compareStr2.concat(w1);
        }
        long end2 = System.nanoTime();
        System.out.println("String by concat(), time: "+(end2-start2));

        StringBuilder compareStr3 = new StringBuilder("");
        long start3 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            compareStr3.append(w1);
        }
        compareStr3.toString();
        long end3 = System.nanoTime();
        System.out.println("String by StringBuilder, time: "+(end3-start3));
    }
}
