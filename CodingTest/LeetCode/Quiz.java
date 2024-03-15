package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}

class Solution {
    public int[] productExceptSelf(final int[] nums) {
        final int len = nums.length;

        final int[] answer = new int[len];
        final int[] left = new int[len];
        final int[] right = new int[len];

        //left 초기화
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        //right 초기화
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        //answer 초기화
        for (int i = 0; i < len; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
