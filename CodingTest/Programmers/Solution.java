package CodingTest.Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(final int n, final int[] works) {
        long answer = 0;

        //제곱을 최소화하기 위해서는 제일 일이 많은 애들부터 줄여야 함
        //우선순위큐에 넣어서 제일 높은 애들을 1씩 제거하고,
        //남은 값들을 제곱해서 return하자

        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (final int work : works) {
            pq.add(work);
        }

        for (int i = 0; i < n; i++) {
            final int top = pq.poll();

            if (top == 0) {
                pq.add(top);
                continue;
            }

            pq.add(top - 1);
        }

        while (!pq.isEmpty()) {
            final int top = pq.poll();
            answer += ((long) top * top);
        }

        return answer;
    }
}
