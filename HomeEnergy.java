import java.util.Scanner;

abstract class App {

    double hrs;

    App(double hrs) {
        this.hrs = hrs;
    }

    abstract double power();

    boolean saver() {
        return false;
    }

    double units() {

        double u = power() * hrs / 1000;

        if (saver()) {
            u = u * 0.75;
        }

        return u;
    }

    double cost() {
        return units() * 8;
    }
}

class Fridge extends App {

    Fridge(double hrs) {
        super(hrs);
    }

    double power() {
        return 150;
    }
}

class AC extends App {

    boolean sm;

    AC(double hrs, boolean sm) {
        super(hrs);
        this.sm = sm;
    }

    double power() {
        return 1500;
    }

    boolean saver() {
        return sm;
    }
}

class TV extends App {

    TV(double hrs) {
        super(hrs);
    }

    double power() {
        return 100;
    }
}

class Washer extends App {

    boolean sm;

    Washer(double hrs, boolean sm) {
        super(hrs);
        this.sm = sm;
    }

    double power() {
        return 500;
    }

    boolean saver() {
        return sm;
    }
}

public class HomeEnergy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hrs = sc.nextDouble();

            boolean sm = false;

            if (sc.hasNext("SAVER")) {
                sm = true;
                sc.next();
            }

            if ((type.equals("FRIDGE") || type.equals("TV")) && sm) {

                System.out.println(
                        type + ": saver mode not supported"
                );
                continue;
            }

            App a;

            if (type.equals("FRIDGE"))
                a = new Fridge(hrs);
            else if (type.equals("AC"))
                a = new AC(hrs, sm);
            else if (type.equals("TV"))
                a = new TV(hrs);
            else
                a = new Washer(hrs, sm);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type,
                    a.units(),
                    a.cost()
            );

            total += a.cost();
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                total
        );
    }
}