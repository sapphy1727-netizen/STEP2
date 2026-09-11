import java.util.Scanner;
import java.util.Arrays;

public class Problem5 implements Comparable<Problem5> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Problem5(String name, int matchesPlayed,
                    double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Problem5 other) {
        if (this.battingAverage < other.battingAverage) {
            return 1;
        } else if (this.battingAverage > other.battingAverage) {
            return -1;
        } else {
            return 0;
        }
    }

    static String draftAndRank(Problem5[] players) {

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                count++;
            }
        }

        Problem5[] draftable = new Problem5[count];

        int j = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[j] = players[i];
                j++;
            }
        }

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result + (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Problem5[] players = {
            new Problem5("Virat", 15, 48.0, false),
            new Problem5("Rahul", 7, 55.0, false),
            new Problem5("Sameer", 3, 60.0, false),
            new Problem5("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);

        System.out.println(result);
    }
}