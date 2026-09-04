import java.util.Scanner;

public class WEEK4Q4 {

    // Method to normalize the code
    static String normalizeCode(String raw) {

        // Remove leading and trailing spaces
        raw = raw.trim();

        // Convert first 3 characters to uppercase
        String firstThree = raw.substring(0, 3).toUpperCase();

        // Keep the remaining characters unchanged
        String remaining = raw.substring(3);

        // Join both parts
        return firstThree + remaining;
    }

    // Method to validate and format the code
    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract publisher code
        String publisher = code.substring(0, 3);

        // Extract year
        String year = code.substring(3, 7);

        // Extract catalog number
        String catalog = code.substring(7, 13);

        // Build final output
        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(publisher)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = sc.nextLine();

        // Step 1: Normalize
        String normalized = normalizeCode(raw);

        // Step 2: Validate and format
        String result = validateAndFormat(normalized);

        // Print result
        System.out.println(result);

        sc.close();
    }
}