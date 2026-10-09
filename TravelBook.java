import java.util.Scanner;

abstract class Ticket {

    double km;
    static final double FEE = 50;

    Ticket(double km) {
        this.km = km;
    }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Ticket {

    Bus(double km) {
        super(km);
    }

    double fare() {
        return km * 2;
    }
}

class Train extends Ticket {

    Train(double km) {
        super(km);
    }

    double fare() {
        return km * 1.5;
    }
}

class Flight extends Ticket {

    Flight(double km) {
        super(km);
    }

    double fare() {
        return 2500 + (km * 4);
    }
}

public class TravelBook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();

            Ticket t;

            if (type.equals("BUS"))
                t = new Bus(km);
            else if (type.equals("TRAIN"))
                t = new Train(km);
            else
                t = new Flight(km);

            System.out.printf(
                    "%s: %.2f%n",
                    type,
                    t.total());
        }
    }
}