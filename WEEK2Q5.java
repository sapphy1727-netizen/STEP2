import java.util.*;

public class WEEK2Q5 {

    static void printFilteredWordFrequency(String feedback) {

        // Create stop-word set
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Convert everything to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into individual words
        String[] words = feedback.split("\\s+");

        // HashMap to store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        // Count words
        for (String word : words) {

            // Ignore stop words
            if (stopWords.contains(word)) {
                continue;
            }

            // If word already exists
            if (frequency.containsKey(word)) {

                frequency.put(
                    word,
                    frequency.get(word) + 1
                );

            } else {

                // First occurrence
                frequency.put(word, 1);
            }
        }

        // Convert HashMap entries to a list
        List<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        list.sort((a, b) ->
            b.getValue() - a.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}