
import java.util.*;

public class BestSingleTradeProfit {
    static int maxProfit(int[] a) {
        int min = a[0], profit = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];

            if (a[i] - min > profit)
                profit = a[i] - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println(maxProfit(a));
    }
}
