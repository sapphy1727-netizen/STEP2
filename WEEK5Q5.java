import java.util.Scanner;
import java.util.Arrays;

public class WEEK5Q5 {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double getCompositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {

            if (this.getCompositeScore() < other.getCompositeScore()) {
                return 1;
            }
            else if (this.getCompositeScore() > other.getCompositeScore()) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlistedTemp = new Candidate[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                shortlistedTemp[count] = candidates[i];
                count++;
            }
        }

        Candidate[] shortlistedArray = Arrays.copyOf(shortlistedTemp, count);

        Arrays.sort(shortlistedArray);

        String result = "";

        for (int i = 0; i < shortlistedArray.length; i++) {

            result = result + (i + 1) + ". "
                    + shortlistedArray[i].name + " ("
                    + shortlistedArray[i].getCompositeScore() + ")";

            if (i < shortlistedArray.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);

        System.out.println(result);

        sc.close();
    }
}