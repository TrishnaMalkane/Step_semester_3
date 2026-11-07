
import java.util.*;

public class TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] a) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i]))
                return true;
            set.add(a[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.next();

        System.out.println(hasDuplicate(a));
    }
}
