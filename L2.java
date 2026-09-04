import java.util.Scanner;

class HostelRoom {
    String roomNo;
    int occupied;
}

public class L2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HostelRoom roomA = new HostelRoom();
        HostelRoom roomB = new HostelRoom();

        roomA.roomNo = sc.nextLine();
        roomB.roomNo = sc.nextLine();

        roomA.occupied++;
        roomA.occupied++;
        roomA.occupied++;

        System.out.println(roomA.roomNo + " occupied: " + roomA.occupied);
        System.out.println(roomB.roomNo + " occupied: " + roomB.occupied);

        sc.close();
    }
}