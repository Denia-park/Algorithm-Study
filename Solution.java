import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] cards) {
        int maxValue = 0;

        for (int card : cards) {
            int[] newCardArr = Arrays.copyOf(cards, cards.length);
            Set<Integer> set = new HashSet<Integer>();

            int tempCard = card;

            while (!set.contains(tempCard)) {
                set.add(tempCard);

                tempCard = newCardArr[tempCard - 1];
            }

            int firstBoxNum = set.size();

            for (int j : newCardArr) {
                if (set.contains(j)) continue;

                int secondBoxNum = 0;

                tempCard = j;

                while (!set.contains(tempCard)) {
                    set.add(tempCard);

                    secondBoxNum++;

                    tempCard = newCardArr[tempCard - 1];
                }

                maxValue = Math.max(maxValue, firstBoxNum * secondBoxNum);
            }
        }

        return maxValue;
    }
}
