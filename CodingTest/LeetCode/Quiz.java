package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(new Food("abc", "B", 1).equals(new Food("abc", "B", 2)));

        solution.maxProductDifference(new int[]{5, 6, 2, 7, 4});
    }
}

class Solution {
    public int maxProductDifference(final int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }
}
