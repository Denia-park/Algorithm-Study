package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maxProduct(new int[]{3, 4, 5, 2}));
    }
}

class Solution {
    public int maxProduct(final int[] nums) {
        Arrays.sort(nums);

        int answer = 1;

        for (int i = nums.length - 1; i >= nums.length - 2; i--) {
            answer *= (nums[i] - 1);
        }

        return answer;
    }
}
