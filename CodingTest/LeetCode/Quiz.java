package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.majorityElement(
                new int[]{3, 2, 3}
        ));
        System.out.println(solution.majorityElement(
                new int[]{2, 2, 1, 1, 1, 2, 2}
        ));
    }
}

class Solution {
    public int majorityElement(final int[] nums) {
        int max = 0;
        int key = 0;

        final Map<Integer, Integer> map = new HashMap<>();

        for (final int num : nums) {
            final Integer i = map.getOrDefault(num, 0);

            if (i + 1 > max) {
                max = i + 1;
                key = num;
            }

            map.put(num, i + 1);
        }

        return key;
    }
}
