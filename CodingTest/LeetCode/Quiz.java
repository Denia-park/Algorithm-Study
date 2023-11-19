package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.reductionOperations(new int[]{5, 1, 3}));
        System.out.println(solution.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(solution.reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }
}

class Solution {
    public int reductionOperations(final int[] nums) {
        int count = 0;

        Arrays.sort(nums);

        final int numsLength = nums.length;
        for (int i = numsLength - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                count += numsLength - i;
            }
        }

        return count;
    }
}
