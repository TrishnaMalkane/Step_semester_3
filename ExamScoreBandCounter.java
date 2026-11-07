
import java.util.*;

public class ExamScoreBandCounter {
    static int countInBand(int[] a, int low, int high) {
        int l = 0, r = a.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] < low)
                l = mid + 1;
            else
                r = mid;
        }
        int start = l;

        l = 0;
        r = a.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] <= high)
                l = mid + 1;
            else
                r = mid;
        }
        return l - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(a, low, high));
    }
}
