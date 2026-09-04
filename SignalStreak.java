public class SignalStreak {
    static void findLongestStreak(String signalLog) {
        char longestChar = signalLog.charAt(0);
        int longest = 1, current = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }
            if (current > longest) {
                longest = current;
                longestChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestChar + "' repeated " + longest + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGGYRR");
    }
}
