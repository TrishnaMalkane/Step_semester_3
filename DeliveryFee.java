import java.util.Scanner;

abstract class Delivery {

    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class Standard extends Delivery {

    Standard(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + (0.5 * weight) + (0.1 * distance);
    }
}

class Express extends Delivery {

    Express(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + (1 * weight) + (0.2 * distance);
    }
}

class International extends Delivery {

    double customsFee;

    International(double weight,
            double distance,
            double customsFee) {

        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 +
                (2 * weight) +
                (0.5 * distance) +
                customsFee;
    }
}

public class DeliveryFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            Delivery d;

            if (type.equals("STANDARD")) {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                d = new Standard(weight, distance);

            } else if (type.equals("EXPRESS")) {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();

                d = new Express(weight, distance);

            } else {

                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                double customs = sc.nextDouble();

                d = new International(
                        weight,
                        distance,
                        customs);
            }

            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}