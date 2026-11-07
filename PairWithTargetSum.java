
import java.util.*;

public class PairWithTargetSum {
    static boolean hasPairWithSum(int[] a, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            int need = target - a[i];

            if (set.contains(need))
                return true;

            set.add(a[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int target = sc.nextInt();
        System.out.println(hasPairWithSum(a, target));
    }
}
