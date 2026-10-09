import java.util.Scanner;

abstract class Seat {
    int cnt;

    Seat(int cnt) {
        this.cnt = cnt;
    }

    abstract double amt();

    double fee() {
        return cnt * 20;
    }
}

class Regular extends Seat {

    Regular(int cnt) {
        super(cnt);
    }

    double amt() {
        return cnt * 150 + fee();
    }
}

class Premium extends Seat {

    Premium(int cnt) {
        super(cnt);
    }

    double amt() {
        return cnt * 250 + fee();
    }
}

class Recliner extends Seat {

    Recliner(int cnt) {
        super(cnt);
    }

    double amt() {
        return cnt * 400 + fee();
    }
}

public class MovieTicket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int cnt = sc.nextInt();

            Seat s;

            if (type.equals("REGULAR"))
                s = new Regular(cnt);
            else if (type.equals("PREMIUM"))
                s = new Premium(cnt);
            else
                s = new Recliner(cnt);

            double a = s.amt();

            System.out.printf("%s: %.2f%n", type, a);

            total += a;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}