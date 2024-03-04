package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

//슬라이딩 윈도우로 풀어보기
class Solution {
    public int solution(final int[] stones, final int k) {
        final int length = stones.length;
        final Deque<Data> dq = new ArrayDeque<>();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            final int curVal = stones[i];
            final Data data = new Data(i, curVal);

            while (!dq.isEmpty() && dq.peekFirst().idx <= (i - k)) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && dq.peekLast().val <= curVal) {
                dq.pollLast();
            }

            dq.addLast(data);

            //k-1 번째부터 슬라이딩 윈도우의 크기가 Max이므로 해당 값 중에 최소 값을 구한다.
            if (i >= (k - 1)) {
                answer = Math.min(answer, dq.peekFirst().val);
            }
        }

        return answer;
    }

    class Data {
        int idx;
        int val;

        public Data(final int idx, final int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
