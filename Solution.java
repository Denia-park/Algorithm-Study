import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] cards;

    public int solution(int[] paramCards) {
        cards = paramCards;
        int maxValue = 0;

        //1번 상자 그룹 구하기
        for (int selectCardOn1st : cards) {
            Set<Integer> set = new HashSet<Integer>();

            int firstBoxNum = selectingBoxUntilEnd(selectCardOn1st, set);

            //2번 상자 그룹 구하기
            for (int selectCardOn2st : cards) {
                int secondBoxNum = selectingBoxUntilEnd(selectCardOn2st, set);

                maxValue = Math.max(maxValue, firstBoxNum * secondBoxNum);
            }
        }

        return maxValue;
    }

    private int selectingBoxUntilEnd(int selectCard, Set<Integer> set) {
        int tempCard = selectCard;

        int rtVal = 0;

        while (!set.contains(tempCard)) {
            set.add(tempCard);
            rtVal++;

            tempCard = cards[tempCard - 1];
        }

        return rtVal;
    }
}
