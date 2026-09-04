public class palindrome {
    static boolean isPalindromeIterative(String text) {
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return check(text, 0, text.length() - 1);
    }

    static boolean check(String s, int i, int j) {
        if (i >= j)
            return true;
        if (s.charAt(i) != s.charAt(j))
            return false;
        return check(s, i + 1, j - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        String rev = new StringBuilder(text).reverse().toString();
        return text.equals(rev);
    }

    public static void main(String[] args) {
        String word = "madam";
        System.out.println("Iterative: " + isPalindromeIterative(word));
        System.out.println("Recursive: " + isPalindromeRecursive(word));
        System.out.println("Array Reversal: " + isPalindromeArrayReversal(word));
    }
}
