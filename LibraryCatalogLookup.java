
import java.util.*;

public class LibraryCatalogLookup {
    static String findBook(String[][] a, String target) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int cmp = a[mid][0].compareTo(target);

            if (cmp == 0)
                return a[mid][1];
            else if (cmp < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] a = new String[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextLine();
            a[i][1] = sc.nextLine();
        }

        String target = sc.nextLine();
        System.out.println(findBook(a, target));
    }
}
