public class typeAccuracy {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatch == -1) {
                    firstMismatch = i + 1; // position is 1-based
                }
            }
        }

        double accuracy = (matched * 100.0) / original.length();
        System.out.println("Matched: " + matched + "/" + original.length() + " | Accuracy: " + accuracy + "%");

        if (firstMismatch != -1) {
            System.out.println("First Mismatch at position " + firstMismatch +
                    " ('" + original.charAt(firstMismatch - 1) + "' vs '" + typed.charAt(firstMismatch - 1) + "')");
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
