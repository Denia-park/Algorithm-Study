package CodingTest.LeetCode;

import java.util.Arrays;
import java.util.Stack;

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

        final Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            final int num = nums[i];

            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }

            final Integer peek = stack.peek();
            if (num == peek) {
                stack.push(num);
                continue;
            }

            count += stack.size();
            stack.push(num);
        }

        return count;
    }
}
