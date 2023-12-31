package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        final int length = citations.length;

        for (int idx = 0; idx < citations.length; idx++) {
            final int citation = citations[idx];

            final int upperCount = length - idx;
            final int lowerCount = idx;

            if (lowerCount <= citation && citation <= upperCount) {
                answer = citation;
            }
        }

        return answer;
    }
}
