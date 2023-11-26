public class SingleClubMember extends Member implements Calculator<Integer> {
    private int club;

    public SingleClubMember(char pMemberType, int pMemberId, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberId, pName, pFees);
        this.club = pClub;
    }

    @Override
    public String toString() {
        return super.toString() + ","+club;
    }

    public void setClub(int pClub) {
        this.club = pClub;
    }

    public int getClub() {
        return club;
    }


    @Override
    public double calculateFees(Integer clubId) {
        return 0;
    }
}
