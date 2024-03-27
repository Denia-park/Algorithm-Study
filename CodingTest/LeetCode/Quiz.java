package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.numSubarrayProductLessThanK(
                        new int[]{10, 5, 2, 6}, 100
                )
        );

        System.out.println(
                solution.numSubarrayProductLessThanK(
                        new int[]{1, 2, 3}, 0
                )
        );
    }
}

class Solution {
    public int numSubarrayProductLessThanK(final int[] nums, final int k) {
        if (k == 0) return 0;

        int left = 0;
        int product = 1;

        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            answer += (right - left + 1);
        }

        return answer;
    }
}
