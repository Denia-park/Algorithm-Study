package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(solution.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(solution.maxFrequency(new int[]{3, 9, 6}, 2));
    }
}

class Solution {
    public int maxFrequency(final int[] nums, int k) {
        Arrays.sort(nums);

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            final int curValue = nums[i];
            final int preValue = nums[i - 1];

            final int minusValue = (curValue - preValue) * count;

            if (minusValue <= k) {
                count++;
                k -= minusValue;
            }
        }

        return count;
    }
}
