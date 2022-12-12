import java.util.HashMap;
import java.util.Map;

class Solution {
    final int UNIT_PRICE = 100;
    Map<String, Member> members;
    int[] answer;

    public int[] solution(String[] enrollNameList, String[] referralNameList, String[] sellerNameList, int[] sellAmount) {
        answer = new int[enrollNameList.length];
        members = new HashMap<>();

        enrollMembers(enrollNameList);

        updateMemberReferral(enrollNameList, referralNameList);

        calculateMemberCreditBySellAmount(sellerNameList, sellAmount);

        updateAnswer(enrollNameList);

        return answer;
    }

    private void updateMemberReferral(String[] enrollNameList, String[] referralNameList) {
        for (int i = 0; i < referralNameList.length; i++) {
            if (referralNameList[i].equals("-")) continue;

            Member curMember = members.get(enrollNameList[i]);
            Member referralMember = members.get(referralNameList[i]);

            curMember.setReferral(referralMember);
        }
    }

    private void enrollMembers(String[] enrollNameList) {
        for (String name : enrollNameList) {
            members.put(name, new Member(name));
        }
    }

    private void calculateMemberCreditBySellAmount(String[] sellerNameList, int[] sellAmount) {
        for (int i = 0; i < sellerNameList.length; i++) {
            Member tempSeller = members.get(sellerNameList[i]);
            int tempSellAmount = sellAmount[i] * UNIT_PRICE;

            tempSeller.calculateCredit(tempSellAmount);
        }
    }

    private void updateAnswer(String[] enrollNameList) {
        for (int i = 0; i < enrollNameList.length; i++) {
            int memberCredit = members.get(enrollNameList[i]).getCredit();
            answer[i] = memberCredit;
        }
    }
}

class Member {
    String name;
    Member referral;
    int credit;

    public Member(String name) {
        this.name = name;
        this.referral = null;
        this.credit = 0;
    }

    public String getName() {
        return name;
    }

    public void setReferral(Member referral) {
        this.referral = referral;
    }

    public int getCredit() {
        return credit;
    }

    public void addCredit(int amount) {
        this.credit += amount;
    }

    public void calculateCredit(int tempSellAmount) {
        int restCredit = (int) (tempSellAmount * 0.1f);
        int myCredit = tempSellAmount - restCredit;
        this.addCredit(myCredit);

        if (restCredit == 0 || referral == null) {
            return;
        }

        this.referral.calculateCredit(restCredit);
    }
}
