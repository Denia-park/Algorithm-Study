package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println("2 : " + solution.minOperations(new int[]{2, 1, 2, 2, 3, 3}));
        System.out.println("3 : " + solution.minOperations(new int[]{19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19}));
    }
}

class Solution {
    public int minOperations(final int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();

        //모든 숫자들을 Map으로 센다.
        for (final int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (final Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            final int value = entry.getValue();

            if (value == 1) {
                return -1;
            }

            count += (int) Math.ceil(value / 3.0);
        }

        return count;
    }
}
