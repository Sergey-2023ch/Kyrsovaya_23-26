import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        int choice;
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> m = fh.readFile();
        choice = mm.getChoice();
        while (choice != -1) {
            switch (choice) {
                case 1:
                    mem = mm.addMembers(m);
                    fh.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(m);
                    fh.overRightFile(m);
                    break;
                case 3:
                    mm.printMemberInfo(m);
                    break;
                default:
                    System.out.println("Invalid option");
            }
            choice = mm.getChoice();
        }
        System.out.println("Good bay");
    }
}
