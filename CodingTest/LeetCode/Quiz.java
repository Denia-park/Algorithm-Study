package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        System.out.println(solution.maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }
}

class Solution {
    public int maxFrequencyElements(final int[] nums) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        final int[] arr = new int[101];
        for (final int num : nums) {
            arr[num]++;
        }

        for (final int count : arr) {
            if (count == 0) {
                continue;
            }

            pq.add(count);
        }

        int sum = 0;
        final int max = pq.peek();
        while (!pq.isEmpty()) {
            final int cur = pq.poll();

            if (cur != max) {
                continue;
            }

            sum += cur;
        }

        return sum;
    }
}
