
import java.util.*;

public class BusiestBusRow {
    static void busiestRow(int[][] grid) {
        int max = -1, row = 0;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++)
                sum += grid[i][j];

            if (sum > max) {
                max = sum;
                row = i;
            }
        }

        System.out.println("Row " + row + ", Total " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                grid[i][j] = sc.nextInt();

        busiestRow(grid);
    }
}
