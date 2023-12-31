package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final int[] citations) {
        final int length = citations.length;
        int answer = length;

        Arrays.sort(citations);

        for (int idx = 0; idx < citations.length; idx++) {
            //현재 인용 개수
            final int curCitation = citations[idx];

            //H-index 이상 인용 개수
            final int upperCount = length - idx;
            //H-index 이하 인용 개수
            final int lowerCount = idx;

            //H-index 조건을 만족하는지 확인
            if (answer <= curCitation
                    && (lowerCount <= answer && answer <= upperCount)) {
                break;
            }

            //H-index 조건을 만족하지 않으면 H-index 감소
            answer--;
        }

        return answer;
    }
}
