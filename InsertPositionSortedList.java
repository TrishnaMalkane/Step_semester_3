
import java.util.*;

public class InsertPositionSortedList {
    static int searchInsertPosition(int[] a, int target) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int target = sc.nextInt();
        System.out.println(searchInsertPosition(a, target));
    }
}
