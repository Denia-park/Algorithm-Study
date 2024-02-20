package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}

class Solution {
    public int missingNumber(final int[] nums) {
        final int n = nums.length;
        final int tsum = (n * (n + 1)) / 2;
        final int actualSum = Arrays.stream(nums).sum();
        return tsum - actualSum;
    }
}
