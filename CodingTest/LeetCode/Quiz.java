package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
    }
}

class Solution {
    public int numberOfArithmeticSlices(final int[] nums) {
        final int n = nums.length;
        int totalCount = 0;

        final Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                final long diff = (long) nums[i] - nums[j];

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }

                final int diffInt = (int) diff;

                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);
                if (dp[j].containsKey(diffInt)) {
                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
                    totalCount += dp[j].get(diffInt);
                }
            }
        }

        return totalCount;
    }
}
