package best_practise;

import java.util.Arrays;

public class SubstringRunner {

    /*
     * дана строка aabcbbabcbbaaccdbac
     * найти вхождение abc
     * */
    public static void main(String[] args) {
        String input = "aabcbbabcbbaaccdbac";
        String search = "abc";

        char[] searchArray = search.toCharArray();
        search.getChars(0, search.length(), searchArray, 0);
        for (int i = 0; i < input.length() - search.length() + 1; i++) {
            char[] candidateArray = new char[search.length()];
            input.getChars(i, i + search.length(), candidateArray, 0);
            if (isEquals(searchArray, candidateArray)) {
                System.out.println(i);
                System.out.println(Arrays.toString(candidateArray));
                System.out.println(Arrays.toString(searchArray));
            }
        }
    }

    static boolean isEquals(char[] arr1, char[] arr2) {
        if (arr1 == arr2) return true;

        if (arr1 == null || arr2 == null) return false;

        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
