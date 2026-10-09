import java.util.Scanner;

abstract class Parcel {

    double wt, val;

    Parcel(double wt, double val) {
        this.wt = wt;
        this.val = val;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class Standard extends Parcel {

    Standard(double wt, double val) {
        super(wt, val);
    }

    double charge() {
        return 40 + wt * 10;
    }
}

class Express extends Parcel {

    Express(double wt, double val) {
        super(wt, val);
    }

    double charge() {
        return 80 + wt * 15;
    }

    double insurance() {
        return val * 0.02;
    }
}

class Fragile extends Parcel {

    Fragile(double wt, double val) {
        super(wt, val);
    }

    double charge() {
        return 40 + wt * 10 + 50;
    }

    double insurance() {
        return val * 0.02;
    }
}

public class ParcelShip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grand = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double wt = sc.nextDouble();
            double val = sc.nextDouble();

            Parcel p;

            if (type.equals("STANDARD"))
                p = new Standard(wt, val);
            else if (type.equals("EXPRESS"))
                p = new Express(wt, val);
            else
                p = new Fragile(wt, val);

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type,
                    p.charge(),
                    p.insurance(),
                    p.total()
            );

            grand += p.total();
        }

        System.out.printf("Grand Total: %.2f%n", grand);
    }
}