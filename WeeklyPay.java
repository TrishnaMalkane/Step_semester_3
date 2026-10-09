import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {

    double sal;

    FullTime(String name, double sal) {
        super(name);
        this.sal = sal;
    }

    double pay() {
        return sal;
    }
}

class Hourly extends Staff {

    double hrs, rate;

    Hourly(String name, double hrs, double rate) {
        super(name);
        this.hrs = hrs;
        this.rate = rate;
    }

    double pay() {

        if (hrs <= 40)
            return hrs * rate;

        return 40 * rate +
                (hrs - 40) * rate * 1.5;
    }
}

class Intern extends Staff {

    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyPay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            Staff s;

            if (type.equals("FULLTIME")) {

                String name = sc.next();
                double sal = sc.nextDouble();

                s = new FullTime(name, sal);
            }

            else if (type.equals("HOURLY")) {

                String name = sc.next();
                double hrs = sc.nextDouble();
                double rate = sc.nextDouble();

                s = new Hourly(name, hrs, rate);
            }

            else {

                String name = sc.next();
                double st = sc.nextDouble();

                s = new Intern(name, st);
            }

            double p = s.pay();

            System.out.printf("%s: %.2f%n",
                    s.name, p);

            total += p;
        }

        System.out.printf(
                "Total Payroll: %.2f%n",
                total);
    }
}