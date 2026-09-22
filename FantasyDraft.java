import java.util.Arrays;

class Player implements Comparable<Player> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name,
            int matchesPlayed,
            double battingAverage,
            boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experienced player rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined rule
    static boolean isDraftable(int matchesPlayed,
            boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage);
    }
}

public class FantasyDraft {

    static String draftAndRank(Player[] players) {

        Player[] selected = new Player[players.length];
        int count = 0;

        for (Player p : players) {

            if (Player.isDraftable(p.matchesPlayed)
                    || Player.isDraftable(
                            p.matchesPlayed,
                            p.injured)) {

                selected[count] = p;
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(selected, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result += (i + 1)
                    + ". "
                    + finalList[i].name;

            if (i < finalList.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

                new Player(
                        "Virat",
                        15,
                        48.0,
                        false),

                new Player(
                        "Rahul",
                        7,
                        55.0,
                        false),

                new Player(
                        "Sameer",
                        3,
                        60.0,
                        false),

                new Player(
                        "Dev",
                        12,
                        20.0,
                        true)
        };

        System.out.println(
                draftAndRank(players));
    }
}