import java.util.Scanner;

abstract class Cab {

    double km;
    String time;

    Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    abstract double fare();
}

class Mini extends Cab {

    Mini(double km, String time) {
        super(km, time);
    }

    double fare() {
        return km * 10;
    }
}

class Sedan extends Cab {

    Sedan(double km, String time) {
        super(km, time);
    }

    double fare() {

        double f = km * 14;

        if (time.equals("NIGHT"))
            f += f * 0.2;

        return f;
    }
}

class SUV extends Cab {

    SUV(double km, String time) {
        super(km, time);
    }

    double fare() {

        double f = km * 18;

        if (time.equals("NIGHT"))
            f += f * 0.2;

        return f;
    }
}

public class CityCab {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (type.equals("MINI") &&
                time.equals("NIGHT")) {

                System.out.println(
                        "MINI: night service not available"
                );
                continue;
            }

            Cab c;

            if (type.equals("MINI"))
                c = new Mini(km, time);
            else if (type.equals("SEDAN"))
                c = new Sedan(km, time);
            else
                c = new SUV(km, time);

            double fare = c.fare();

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    fare
            );

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );
    }
}