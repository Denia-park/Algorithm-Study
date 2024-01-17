package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println("2 : " + solution.uniqueOccurrences(new int[]{1, 2}));
        System.out.println("3 : " + solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}

class Solution {
    public boolean uniqueOccurrences(final int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (final int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        final Set<Integer> occurrences = new HashSet<>();

        for (final Integer occur : map.values()) {
            if (occurrences.contains(occur)) {
                return false;
            }

            occurrences.add(occur);
        }

        return true;
    }
}
