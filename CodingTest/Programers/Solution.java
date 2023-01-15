package CodingTest.Programers;

import java.util.Arrays;

class Solution {
    public int solution(int scoreMax, int appleNum, int[] scores) {
        int answer = 0;

        Arrays.sort(scores);

        int idx = scores.length;

        while (idx >= appleNum) {
            answer += (scores[idx - appleNum] * appleNum);

            idx -= appleNum;
        }

        return answer;
    }
}
