package best_practise;

import java.util.LinkedList;

public class BracketsValidationRunner {

    public static void main(String[] args) {

        String bracketsIsValid = "[{{[]}}]";

        String bracketsIsNotValid = "[{{[]}]]";

        String bracketsIsValid2 = "[]{{}}[{}]";

        System.out.println(isValid(bracketsIsValid));
        System.out.println(isValid(bracketsIsNotValid));
        System.out.println(isValid(bracketsIsValid2));
    }

    static boolean isValid(String brackets) {
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '[' || brackets.charAt(i) == '{') {
                queue.push(brackets.charAt(i));
            }
            if (brackets.charAt(i) == ']' || brackets.charAt(i) == '}') {

                if (queue.size() == 0) return false;

                char ch1 = queue.pop();
                char ch2 = brackets.charAt(i);

                if (ch1 == '[' && ch2 == '}' || ch1 == '{' && ch2 == ']') return false;
            }
        }

        return true;
    }
}
