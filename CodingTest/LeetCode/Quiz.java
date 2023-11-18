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
    public int maxFrequency(final int[] nums, final int k) {
        Arrays.sort(nums);

        int maxFrequency = 0;
        long currentSum = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left++];
            }

            maxFrequency = Math.max(maxFrequency, (right - left + 1));
        }

        return maxFrequency;
    }
}
