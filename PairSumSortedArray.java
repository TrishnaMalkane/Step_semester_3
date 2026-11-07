
import java.util.*;

public class PairSumSortedArray {
    static void pairSumSorted(int[] a, int target) {
        int l = 0, r = a.length - 1;

        while (l < r) {
            int sum = a[l] + a[r];

            if (sum == target) {
                System.out.println("(" + a[l] + ", " + a[r] + ")");
                return;
            } else if (sum < target)
                l++;
            else
                r--;
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int target = sc.nextInt();
        pairSumSorted(a, target);
    }
}
