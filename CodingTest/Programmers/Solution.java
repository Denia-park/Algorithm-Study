package CodingTest.Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(final int n, final int[] cores) {
        final PriorityQueue<Core> pq = new PriorityQueue<>(
                Comparator.comparingLong((Core c) -> c.endTime).thenComparingInt((Core c) -> c.idx)
        );

        for (int i = 0; i < cores.length; i++) {
            pq.add(new Core(i + 1, cores[i]));
        }

        for (int i = 0; i < n; i++) {
            final Core core = pq.poll();

            core.endTime += core.spend;

            pq.add(core);
        }

        while (pq.size() != 1) {
            pq.poll();
        }

        return pq.poll().idx;
    }

    class Core {
        int idx;
        long endTime;
        int spend;

        public Core(final int idx, final int spend) {
            this.idx = idx;
            this.spend = spend;
        }
    }
}
