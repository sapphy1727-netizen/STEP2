import java.util.Scanner;

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

public class L4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();
        String title = sc.nextLine();

        Course c = new Course(code, title);

        System.out.println(c.code + " - " + c.title);

        sc.close();
    }
}