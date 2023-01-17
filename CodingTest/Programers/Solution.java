package CodingTest.Programers;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        boolean flag = false;

        int houseIdx = n - 1;
        while (houseIdx >= 0) {
            if (deliveries[houseIdx] == 0 && pickups[houseIdx] == 0) {
                houseIdx--;
                continue;
            }

            int myCap = 0;
            for (int i = houseIdx; i >= 0; i--) {
                if (deliveries[i] == 0 || myCap == cap) {
                    continue;
                }

                if (myCap + deliveries[i] <= cap) {
                    myCap += deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= (cap - myCap);
                    myCap = cap;
                }
                flag = true;
            }

            myCap = 0;
            for (int i = houseIdx; i >= 0; i--) {
                if (pickups[i] == 0 || myCap == cap) {
                    continue;
                }

                if (myCap + pickups[i] <= cap) {
                    myCap += pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= (cap - myCap);
                    myCap = cap;
                }
                flag = true;
            }

            if (flag) {
                answer += ((houseIdx + 1) * 2L);
            }
        }

        return answer;
    }
}
