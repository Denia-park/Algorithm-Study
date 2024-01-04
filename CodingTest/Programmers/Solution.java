package CodingTest.Programmers;

/*
아이디어
- 이분탐색을 사용한다.

시간복잡도
- O(N * lnN)

자료형
- long
 */

import java.util.Arrays;

class Solution {
    public long solution(final int n, final int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = (long) times[0] * n;

        while (left <= right) {
            final long curTime = left + (right - left) / 2;

            long completeCheckNum = 0;

            for (final int eachTime : times) {
                completeCheckNum += curTime / eachTime;
            }

            if (completeCheckNum >= n) {
                answer = curTime;
                right = curTime - 1;
            } else {
                left = curTime + 1;
            }
        }

        return answer;
    }
}
