package CodingTest.Programmers;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx1Max = cards1.length;
        int cardIdx2 = 0;
        int cardIdx2Max = cards2.length;

        for (int i = 0; i < goal.length; i++) {
            String curStr = goal[i];
            if (cardIdx1 < cardIdx1Max && curStr.equals(cards1[cardIdx1])) {
                cardIdx1++;
            } else if (cardIdx2 < cardIdx2Max && curStr.equals(cards2[cardIdx2])) {
                cardIdx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
