package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}

class Solution {
    public int numSubarraysWithSum(final int[] nums, final int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }

    private int slidingWindowAtMost(final int[] nums, final int goal) {
        int start = 0;
        int currentSum = 0;
        int totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (start <= end && currentSum > goal) {
                currentSum -= nums[start];
                start++;
            }

            totalCount += (end - start + 1);
        }

        return totalCount;
    }
}
