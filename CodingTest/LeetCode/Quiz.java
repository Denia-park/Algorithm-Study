package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(solution.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
        System.out.println(solution.minPairSum(new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4}));
    }
}

class Solution {
    //정렬
    public int minPairSum(final int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int maxValue = -1;
        while (start < end) {
            final int curValue = nums[start] + nums[end];

            if (curValue > maxValue) {
                maxValue = curValue;
            }

            start++;
            end--;
        }

        return maxValue;
    }
}
