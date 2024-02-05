package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static final int ST = 0;
    static final int ED = 1;

    public int solution(final int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt((int[] value) -> value[ST])
                .thenComparingInt((int[] value) -> value[ED]));

        int preCarEnd = -30001;
        for (final int[] route : routes) {
            if (preCarEnd < route[ST]) {
                answer++;
                preCarEnd = route[ED];
            }
        }

        return answer;
    }
}
