
import java.util.*;

public class SecondBestScore {
    static int secondHighest(int[] a) {
        int first = -1, second = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            } else if (a[i] < first && a[i] > second)
                second = a[i];
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println(secondHighest(a));
    }
}
