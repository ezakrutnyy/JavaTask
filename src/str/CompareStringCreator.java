package str;

public class CompareStringCreator {
    public static void main(String[] args) {

        String w1 = "One apple and pineapple!";

        /* time: 17401 */
        String compareStr = "";
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            compareStr += w1;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(String.format("String by '+': %s, time: %d ", compareStr, (endTime1 - startTime1)));

        /* time: 5448 */
        String compareStr2 = "";
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            compareStr2 = compareStr2.concat(w1);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(String.format("String by concat(): %s, time: %d ", compareStr2, (endTime2 - startTime2)));


        /* time: 4 */
        final StringBuilder compareStr3 = new StringBuilder();
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            compareStr3.append(w1);
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println(String.format("String by StringBuilder: %s, time: %d ",
                compareStr3, (endTime3 - startTime3)));
    }
}


