import java.util.Scanner;
public class DAY2Q4 {
    static String maskPhoneNumber(String phone) {
        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        // Check that every character is a digit
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        // Get last 4 digits
        String lastFour = phone.substring(6);
        // Create masked number
        StringBuilder result = new StringBuilder("XXXXXX");
        // Insert '-' after XXXXXX
        result.insert(6, "-");
        // Add last 4 digits
        result.append(lastFour);
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        String result = maskPhoneNumber(phone);
        System.out.println(result);
        sc.close();
    }
}