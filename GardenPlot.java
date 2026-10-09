import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    double r;

    Circle(String owner, double r) {
        super(owner);
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Plot {
    double l, w;

    Rectangle(String owner, double l, double w) {
        super(owner);
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

class Triangle extends Plot {
    double b, h;

    Triangle(String owner, double b, double h) {
        super(owner);
        this.b = b;
        this.h = h;
    }

    double area() {
        return 0.5 * b * h;
    }
}

public class GardenPlot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            Plot p;

            if (type.equals("CIRCLE")) {
                String o = sc.next();
                double r = sc.nextDouble();
                p = new Circle(o, r);
            } else if (type.equals("RECTANGLE")) {
                String o = sc.next();
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                p = new Rectangle(o, l, w);
            } else {
                String o = sc.next();
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                p = new Triangle(o, b, h);
            }

            double a = p.area();

            System.out.printf("%s (%s): %.2f%n",
                    p.owner,
                    type,
                    a);

            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}