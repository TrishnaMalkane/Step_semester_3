import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // High CGPA shortcut
    static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    // Borderline CGPA + coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 60;
    }

    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
                other.compositeScore(),
                this.compositeScore());
    }
}

public class PlacementDrive {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] selected = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {

            if (Candidate.isEligible(c.cgpa) ||
                    Candidate.isEligible(c.cgpa, c.codingScore)) {

                selected[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(selected, count);

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1)
                    + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].compositeScore()
                    + ") ";

        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)

        };

        System.out.println(shortlistAndRank(candidates));
    }
}