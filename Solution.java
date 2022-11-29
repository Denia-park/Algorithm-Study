class Solution {
    public int solution(int[] food_times, long k) {
        int idxCheck = 0;

        for (int time = 0; time < k; time++) {
            boolean eatFlag = false;

            while (!eatFlag) {
                if (food_times[idxCheck] != 0) {
                    food_times[idxCheck]--;
                    eatFlag = true;
                }

                idxCheck = (idxCheck + 1) % food_times.length;
            }
        }

        return idxCheck + 1;
    }
}
