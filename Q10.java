
import java.util.*;

class Student {
    String name;
    int marks[] = new int[3];

    double average() {
        int sum = 0;
        for (int i = 0; i < 3; i++)
            sum += marks[i];
        return sum / 3.0;
    }
}

class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        s.name = sc.next();

        for (int i = 0; i < 3; i++)
            s.marks[i] = sc.nextInt();

        double avg = s.average();
        char grade;

        if (avg >= 75)
            grade = 'B';
        else if (avg >= 60)
            grade = 'C';
        else if (avg >= 40)
            grade = 'D';
        else
            grade = 'F';

        System.out.printf("%s: Average %.1f, Grade %c",
                s.name.toUpperCase(), avg, grade);
    }
}
