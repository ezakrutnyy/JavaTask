package best_practise;

public class PalindromeRunner {

    public static void main(String[] args) {

        final String palindrome = "Мама Мыла Раму!";

        /* 1 - через StringBuilder */
        final StringBuilder builder = new StringBuilder(palindrome);
        final String reverseFromBuilder = builder.reverse().toString();
        System.out.println("By StringBuilder " + reverseFromBuilder);

        /* 2 - через char[] и charAt */
        final char[] revertByteArray = new char[palindrome.length()];
        for (int i = 0; i < palindrome.length(); i++) {
            revertByteArray[i] = palindrome.charAt(palindrome.length() - 1 - i);
        }
        System.out.println("By Char Array " + new String(revertByteArray));

    }
}
