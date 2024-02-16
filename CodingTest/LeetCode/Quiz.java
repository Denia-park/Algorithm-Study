package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.findLeastNumOfUniqueInts(
                        new int[]{5, 5, 4}, 1
                )
        );
        System.out.println(
                solution.findLeastNumOfUniqueInts(
                        new int[]{4, 3, 1, 1, 3, 3, 2}, 3
                )
        );
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(final int[] arr, int k) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (final int val : arr) {
            final Integer num = countMap.getOrDefault(val, 0);
            countMap.put(val, num + 1);
        }

        final List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry::getValue));

        int answer = 0;
        for (final Map.Entry<Integer, Integer> entry : entries) {
            final Integer count = entry.getValue();

            if (count <= k) {
                k -= count;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
