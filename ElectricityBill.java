import java.util.Scanner;

abstract class Conn {

    int units;

    Conn(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Conn {

    Home(int units) {
        super(units);
    }

    double bill() {

        if (units <= 100)
            return units * 5;

        return (100 * 5) + ((units - 100) * 7);
    }
}

class Shop extends Conn {

    Shop(int units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Conn {

    Factory(int units) {
        super(units);
    }

    double bill() {

        double b = units * 6;

        if (b < 1000)
            b = 1000;

        return b;
    }
}

public class ElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            Conn c;

            if (type.equals("HOME"))
                c = new Home(units);
            else if (type.equals("SHOP"))
                c = new Shop(units);
            else
                c = new Factory(units);

            double b = c.bill();

            System.out.printf("%s: %.2f%n",
                    type, b);

            total += b;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
`