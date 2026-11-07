
import java.util.*;

public class SpiralOrderTraversal {
    static ArrayList<Integer> spiralOrder(int[][] a) {
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = a.length - 1;
        int left = 0, right = a[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                list.add(a[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(a[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    list.add(a[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    list.add(a[i][left]);
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.println(spiralOrder(a));
    }
}
