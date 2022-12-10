import java.util.PriorityQueue;

class Solution {
    public int solution(int mySoldierNum, int superPass, int[] enemys) {
        if (superPass >= enemys.length) {
            return enemys.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < superPass; i++) {
            pq.offer(enemys[i]);
        }

        int roundCheck = superPass;

        for (int i = superPass; i < enemys.length; i++) {
            int superPassMinValue = pq.peek();

            if (enemys[i] > superPassMinValue) {
                pq.poll();
                pq.offer(enemys[i]);

                if (superPassMinValue > mySoldierNum) {
                    break;
                } else {
                    mySoldierNum -= superPassMinValue;
                }
            } else {
                if (enemys[i] > mySoldierNum) {
                    break;
                } else {
                    mySoldierNum -= enemys[i];
                }
            }

            roundCheck++;
        }

        return roundCheck;
    }
}
