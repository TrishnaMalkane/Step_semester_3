import java.util.Scanner;

abstract class Item {

    String title;
    int days;

    Item(String title, int days) {
        this.title = title;
        this.days = days;
    }

    abstract double fine();
}

class Book extends Item {

    Book(String title, int days) {
        super(title, days);
    }

    double fine() {
        return days * 2;
    }
}

class DVD extends Item {

    DVD(String title, int days) {
        super(title, days);
    }

    double fine() {

        double f = days * 5;

        if (f > 50)
            f = 50;

        return f;
    }
}

class Magazine extends Item {

    Magazine(String title, int days) {
        super(title, days);
    }

    double fine() {
        return days;
    }
}

public class LibraryFine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            Item item;

            if (type.equals("BOOK"))
                item = new Book(title, days);
            else if (type.equals("DVD"))
                item = new DVD(title, days);
            else
                item = new Magazine(title, days);

            double f = item.fine();

            System.out.printf("%s: %.2f%n",
                    item.title, f);

            total += f;
        }

        System.out.printf(
                "Total Fines: %.2f%n",
                total);
    }
}