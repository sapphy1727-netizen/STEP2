import java.util.Scanner;
class Student {
    String name;
    int marks;
}
public class L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        s.name = sc.nextLine();
        s.marks = sc.nextInt();
        System.out.println("Name: " + s.name + " | Marks: " + s.marks);
        sc.close();
    }
}