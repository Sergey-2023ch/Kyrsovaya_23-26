
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    private final Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int c = 0;
        while (c == 0) {
            try {
                c = reader.nextInt();
                if (c == 0) throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException exception) {
                reader.nextLine();
                System.out.println("ERROR:invalid input.Try agan. ");
            }
        }
        return c;
    }

    private void printClubOptions() {
        System.out.println("1) Club Mercury ");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice() {
        int choice;
        System.out.println("WELCOME TO OZON FITNESS CENTER");
        System.out.println("-------------------------------");
        System.out.println("1) Add member \n2) Remove member\n3) Display Member Information");
        System.out.print("Please select an option (or Enter -1 to quit  ");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {

        char memberType;
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("Enter the member's name");
        name = reader.nextLine();

        printClubOptions();
        System.out.println("Enter tne member's clubID");

        club = getIntInput();

        while (club < 1 || club > 4) {
            System.out.println("\n Invalid clubID. Try agan");
            club = getIntInput();
        }

        if (m.size() > 0) {
            memberID = m.getLast().getMemberId() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);

            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("SingleClubMember has been successfully initialized");
            System.out.println();
        } else {
            cal = (n) -> {
                if (n == 4) {
                    return 1200;
                } else {
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);

            m.add(mbr);
            mem = mbr.toString();
            System.out.println("MultiClubMember has been successfully initialized");
            System.out.println();
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Enter memberID to remove");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberId() == memberID) {
                m.remove(i);
                System.out.println("Member is successfully removed");
                System.out.println();
                return;
            }
        }
        System.out.println("Member is not found");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberID;
        System.out.println("Enter memberID of user to display");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberId() == memberID) {
                String[] memberInfo = m.get(i).toString().split(",");
                System.out.println("Member type : " + memberInfo[0]);
                System.out.println("Member ID : " + memberInfo[1]);
                System.out.println("Name : " + memberInfo[2]);
                System.out.println("fees : " + memberInfo[3]);
                if (memberInfo[0].equals("S")) {
                    System.out.println("ClubID " + memberInfo[4]);
                } else {
                    System.out.println("Member Ship Points " + memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("Member ID not found");
    }
}



