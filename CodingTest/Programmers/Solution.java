package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static final int ST = 0;
    static final int ED = 1;

    public int solution(final int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt((int[] value) -> value[ED]));

        int preCarStart = -30001;
        for (final int[] route : routes) {
            if (preCarStart < route[ST]) {
                answer++;
                preCarStart = route[ED];
            }
        }

        return answer;
    }
}
