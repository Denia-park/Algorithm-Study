package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        final int[] answer = new int[n];

        int idx = 0;
        while (n > 0) {
            final int temp = s / n;

            if (temp == 0) {
                return new int[]{-1};
            }

            answer[idx] = temp;
            idx++;

            s -= temp;
            n--;
        }

        Arrays.sort(answer);

        return answer;
    }
}
