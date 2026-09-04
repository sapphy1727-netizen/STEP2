import java.util.Scanner;
public class DAY2Q3 {
    static String validateFileExtension(String filename) {
        int dotPosition = filename.lastIndexOf('.');
        // No dot found
        if (dotPosition == -1) {
            return "Rejected — invalid file type";
        }
        // Extract extension
        String extension = filename.substring(dotPosition + 1);
        // Check accepted extensions
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        } else {

            return "Rejected — invalid file type";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = sc.nextLine();
        String result = validateFileExtension(filename);
        System.out.println(result);
        sc.close();
    }
}