import java.util.HashMap;
import java.util.Map;

class Solution {
    final int UNIT_PRICE = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Member> members = new HashMap<>();

        for (String name : enroll) {
            members.put(name, new Member(name));
        }

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) continue;

            Member curMember = members.get(enroll[i]);
            Member referralMember = members.get(referral[i]);

            curMember.setReferral(referralMember);
        }

        for (int i = 0; i < seller.length; i++) {
            Member tempSeller = members.get(seller[i]);
            int tempSellAmount = amount[i] * UNIT_PRICE;

            tempSeller.calculateCredit(tempSellAmount);
        }

        for (int i = 0; i < enroll.length; i++) {
            int memberCredit = members.get(enroll[i]).getCredit();
            answer[i] = memberCredit;
        }
        return answer;
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

        if (referral == null) {
            return;
        }

        this.referral.calculateCredit(restCredit);
    }
}
