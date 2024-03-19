package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                        2
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'C', 'A', 'B', 'D', 'B'},
                        2
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                        3
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        1
                )
        );
    }
}

class Solution {
    public int leastInterval(final char[] tasks, final int n) {
        final int[] freq = new int[26];
        for (final char ch : tasks) {
            freq[ch - 'A']++;
        }

        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (final int val : freq) {
            if (val > 0) {
                pq.add(val);
            }
        }

        int time = 0;
        final int cycle = n + 1;
        while (!pq.isEmpty()) {
            int tempCycle = cycle;
            final List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while (tempCycle > 0 && !pq.isEmpty()) {
                tempCycle--;

                final int curFreq = pq.poll();

                if (curFreq > 1) {
                    store.add(curFreq - 1);
                }

                taskCount++;
            }
            pq.addAll(store);

            time += pq.isEmpty() ? taskCount : cycle;
        }

        return time;
    }
}
