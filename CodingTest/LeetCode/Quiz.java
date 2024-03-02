package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.sortedSquares(
                new int[]{-4, -1, 0, 3, 10}
        ));
        System.out.println(solution.sortedSquares(
                new int[]{-7, -3, 2, 3, 11}
        ));
    }
}

class Solution {
    public int[] sortedSquares(final int[] nums) {
        final int length = nums.length;
        int left = 0;
        int right = length - 1;

        int idx = length - 1;
        final int[] answer = new int[length];

        while (left <= right) {
            final int lVal = Math.abs(nums[left]);
            final int rVal = Math.abs(nums[right]);

            if (lVal > rVal) {
                answer[idx] = lVal * lVal;
                left++;
            } else {
                answer[idx] = rVal * rVal;
                right--;
            }
            idx--;
        }

        return answer;
    }
}
