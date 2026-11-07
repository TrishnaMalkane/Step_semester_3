
import java.util.*;

public class RemoveDuplicatesSortedArray {
    static int removeDuplicates(int[] a) {
        if (a.length == 0)
            return 0;

        int j = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                a[j] = a[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int len = removeDuplicates(a);

        System.out.println("Length = " + len);
        for (int i = 0; i < len; i++)
            System.out.print(a[i] + " ");
    }
}
