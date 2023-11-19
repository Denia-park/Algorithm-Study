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

        for (int i = nums.length - 1; i > 0; i--) {
            final int num = nums[i];
            final int preNum = nums[i - 1];

            if (num != preNum) {
                final int changeCount = nums.length - i;
                count += changeCount;
            }
        }

        return count;
    }
}
