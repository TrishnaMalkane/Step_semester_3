import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {

    String title;
    LocalDate currentDate = LocalDate.of(2023, 10, 26);

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate getDueDate();
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.split(" ")[0];
            String title = line.substring(type.length()).trim();

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK"))
                item = new Book(title);
            else if (type.equals("DVD"))
                item = new DVD(title);
            else
                item = new Magazine(title);

            System.out.println(
                    item.title + ": " + item.getDueDate());
        }
    }
}