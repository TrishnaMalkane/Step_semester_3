import java.util.*;

public class rockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = { "Rock", "Paper", "Scissors" };
        int wins = 0, losses = 0, draws = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.print("Enter move (Rock/Paper/Scissors): ");
            String player = sc.next();
            String computer = moves[new Random().nextInt(3)];

            String result;
            if (player.equals(computer)) {
                result = "Draw";
                draws++;
            } else if ((player.equals("Rock") && computer.equals("Scissors")) ||
                    (player.equals("Paper") && computer.equals("Rock")) ||
                    (player.equals("Scissors") && computer.equals("Paper"))) {
                result = "Player Wins";
                wins++;
            } else {
                result = "Computer Wins";
                losses++;
            }

            System.out.println("Round " + round + ": " + player + " vs " + computer + "\nResult: " + result);
        }

        double winPercent = (wins * 100.0) / 5;
        System.out.println(
                "Summary Wins: " + wins + ", Losses: " + losses + ", Draws: " + draws + ", Win%: " + winPercent);
    }

}
