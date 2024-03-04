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

            if (i >= k) {
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
