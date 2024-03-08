package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        final int[] answer = new int[n];

        int idx = 0;
        while (n > 0) {
            final int temp = s / n;

            answer[idx] = temp;
            idx++;

            s -= temp;
            n--;
        }

        Arrays.sort(answer);

        return answer;
    }
}
