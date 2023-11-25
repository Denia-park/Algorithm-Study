package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution.getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }
}

class Solution {
    //처음에 한번 0 인덱스를 기준으로, AbsoluteSum을 구한다.
    //index를 옮기면서
    //sum에 index * (nums[index + 1] - nums[index]) 더한다.
    //sum에서 (total - index) * (nums[index + 1] - nums[index]) 뺀다.
    public int[] getSumAbsoluteDifferences(final int[] nums) {
        final int totalLength = nums.length;
        final int[] result = new int[totalLength];

        int total = initAbsoluteSumAt0Idx(nums);

        result[0] = total;

        for (int index = 1; index < totalLength; index++) {
            final int diff = nums[index] - nums[index - 1];

            total += ((index * diff) - ((totalLength - index) * diff));

            result[index] = total;
        }

        return result;

    }

    private int initAbsoluteSumAt0Idx(final int[] nums) {
        int total = 0;

        for (int i = 1; i < nums.length; i++) {
            total += (nums[i] - nums[0]);
        }

        return total;
    }
}
