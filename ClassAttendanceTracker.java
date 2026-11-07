
import java.util.*;

public class ClassAttendanceTracker {
    static void attendanceSummary(int[] days) {
        int present = 0, count = 0, max = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                count++;
                if (count > max)
                    max = count;
            } else
                count = 0;
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++)
            days[i] = sc.nextInt();

        attendanceSummary(days);
    }
}
