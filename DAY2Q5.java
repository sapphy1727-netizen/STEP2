import java.util.Scanner;

public class DAY2Q5 {

    // Normalize the reference
    static String normalizeReference(String raw) {

        // Remove leading and trailing spaces
        raw = raw.trim();

        // Convert first 3 characters to uppercase
        String bankCode = raw.substring(0, 3).toUpperCase();

        // Keep remaining characters unchanged
        String remaining = raw.substring(3);

        // Join them
        return bankCode + remaining;
    }

    // Validate and format
    static String validateAndFormat(String reference) {

        // Check total length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {

                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {

                return "Invalid: body must contain only digits";
            }
        }

        // Extract bank code
        String bankCode = reference.substring(0, 3);

        // Extract date: ddMMyy
        String date = reference.substring(3, 9);

        // Extract sequence number
        String sequence = reference.substring(9, 14);

        // Split date
        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 6);

        // Build output
        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(day)
                .append("/")
                .append(month)
                .append("/")
                .append(year)
                .append(" | SEQ: ")
                .append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        // Step 1: Normalize
        String normalized = normalizeReference(raw);

        // Step 2: Validate and format
        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}