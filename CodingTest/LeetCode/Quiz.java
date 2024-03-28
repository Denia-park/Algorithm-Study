package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.maxSubarrayLength(
                        new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2
                )
        );

        System.out.println(
                solution.maxSubarrayLength(
                        new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1
                )
        );

        System.out.println(
                solution.maxSubarrayLength(
                        new int[]{5, 5, 5, 5, 5, 5, 5}, 4
                )
        );
    }
}

class Solution {
    public int maxSubarrayLength(final int[] nums, final int k) {
        int ans = 0, start = 0;
        final Map<Integer, Integer> frequency = new HashMap();

        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
            while (frequency.get(nums[end]) > k) {
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }
}
