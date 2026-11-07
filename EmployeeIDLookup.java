
import java.util.*;

public class EmployeeIDLookup {
    static HashMap<String, String> buildLookup(String[][] a) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < a.length; i++)
            map.put(a[i][0], a[i][1]);

        return map;
    }

    static String getDepartment(HashMap<String, String> map, String id) {
        return map.getOrDefault(id, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] a = new String[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.next();
            a[i][1] = sc.next();
        }

        HashMap<String, String> map = buildLookup(a);
        String id = sc.next();

        System.out.println(getDepartment(map, id));
    }
}
