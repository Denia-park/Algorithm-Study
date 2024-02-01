package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)));
    }
}

class Solution {
    public int[][] divideArray(final int[] nums, final int k) {
        Arrays.sort(nums);

        final int len = nums.length;
        final int[][] answer = new int[len / 3][3];

        for (int i = 0; i < len; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            answer[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }

        return answer;
    }
}
