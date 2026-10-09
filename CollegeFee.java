import java.util.Scanner;

abstract class Stu {

    String name;

    Stu(String name) {
        this.name = name;
    }

    abstract double fee();

    double busFee() {
        return 12000;
    }
}

class DayScholar extends Stu {

    DayScholar(String name) {
        super(name);
    }

    double fee() {
        return 40000 + busFee();
    }
}

class Hosteller extends Stu {

    Hosteller(String name) {
        super(name);
    }

    double fee() {
        return 40000 + 60000;
    }
}

class Scholar extends Stu {

    Scholar(String name) {
        super(name);
    }

    double fee() {
        return 20000 + busFee();
    }
}

public class CollegeFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Stu s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double f = s.fee();

            System.out.printf("%s: %.2f%n",
                    name, f);

            total += f;
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                total
        );
    }
}
``