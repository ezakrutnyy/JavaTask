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

    private static boolean isValid(String brackets) {
        LinkedList<Character> queue = new LinkedList<>();

        for (int i = 0; i < brackets.length(); i++) {

            char currentBracket = brackets.charAt(i);

            if (currentBracket == '[' || currentBracket == '{') {
                queue.push(currentBracket);
            }
            if (currentBracket == ']' || currentBracket == '}') {

                if (queue.size() == 0) return false;

                char openBracket = queue.pop();
                if (openBracket == '[' && currentBracket == '}' || openBracket == '{' && currentBracket == ']')
                    return false;
            }
        }

        return true;
    }
}
