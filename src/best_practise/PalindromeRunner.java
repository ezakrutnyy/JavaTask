package best_practise;

public class PalindromeRunner {

    public static void main(String[] args) {

        String palindrome = "Мама Мыла Раму!";

        /* 1 - через StringBuilder */
        StringBuilder builder = new StringBuilder(palindrome);
        String reverseFromBuilder = builder.reverse().toString();
        System.out.println("By StringBuilder " + reverseFromBuilder);

        /* 2 - через char[] и charAt */
        char[] revertByteArray = new char[palindrome.length()];
        for (int i = 0; i < palindrome.length(); i++) {
            revertByteArray[i] = palindrome.charAt(palindrome.length() - 1 - i);
        }
        String reverseFromCharArray = new String(revertByteArray);
        System.out.println("By Char Array " + reverseFromCharArray);

    }
}
