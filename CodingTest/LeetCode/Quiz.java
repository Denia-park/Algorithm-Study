package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(final int[] nums) {
        final int length = nums.length;
        final int[] dp = new int[length];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int maxSize = 1;
        int maxIndex = 0;
        for (int end = 1; end < length; end++) {
            for (int loop = 0; loop < end; loop++) {
                if (nums[end] % nums[loop] == 0) {
                    dp[end] = Math.max(dp[end], dp[loop] + 1);

                    if (dp[end] > maxSize) {
                        maxSize = dp[end];
                        maxIndex = end;
                    }
                }
            }
        }

        final List<Integer> result = new ArrayList<>();
        int max = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            final int curVal = nums[i];

            if (max % curVal == 0 && dp[i] == maxSize) {
                result.add(curVal);
                max = curVal;
                maxSize--;
            }
        }

        return result;
    }
}
