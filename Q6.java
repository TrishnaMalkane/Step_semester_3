
import java.util.*;

class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;

        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }

        if (n > 1 && flag == 0)
            System.out.println(n + " is prime");
        else
            System.out.println(n + " is not prime");
    }
}
