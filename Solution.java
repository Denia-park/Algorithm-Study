import java.util.List;

class Solution {
    public int solution(int counselCount, List<Counsel> counsels) {

        int[] counselingPrices = new int[counselCount];
        int[] counselingTimer = new int[counselCount];

        for (int day = 0; day < counselCount; day++) {
            for (int idx = 0; idx <= day; idx++) {
                if (counselingTimer[idx] <= day) {
                    Counsel curCounsel = counsels.get(day);

                    if (day + curCounsel.time <= counselCount) {
                        counselingTimer[idx] = (day + curCounsel.time);
                        counselingPrices[idx] = (counselingPrices[idx] + curCounsel.price);
                    }
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < counselCount; i++) {
            maxValue = Math.max(maxValue, counselingPrices[i]);
        }

        return maxValue;
    }
}
