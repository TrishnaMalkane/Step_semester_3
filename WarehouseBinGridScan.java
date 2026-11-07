
import java.util.*;

public class WarehouseBinGridScan {
    static void warehouseSummary(int[][] a) {
        int total = 0, max = -1, row = 0, col = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                total += a[i][j];

                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Total = " + total);
        System.out.println("Max Coordinate = (" + row + ", " + col + ")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        warehouseSummary(a);
    }
}
