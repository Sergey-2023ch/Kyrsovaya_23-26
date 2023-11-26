import java.io.Serializable;
public class Member implements Serializable {
    private char memberType;
    private int memberId;
    private String name;
    private double fees;

    public Member(char pMemberType, int pMemberId, String pName, double pFees) {
        this.memberType = pMemberType;
        this.memberId = pMemberId;
        this.name = pName;
        this.fees = pFees;
    }


    @Override
    public String toString(){
        return memberType + "," + memberId + "," + name + "," + fees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char pMemberType) {
        this.memberType = pMemberType;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int pMemberId) {
        this.memberId = pMemberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double pFees) {
        this.fees = pFees;
    }
    }

