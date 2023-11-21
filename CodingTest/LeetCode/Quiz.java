package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.countNicePairs(new int[]{42, 11, 1, 97}));
    }
}

class Solution {
    public int countNicePairs(final int[] nums) {
        long answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (isNicePair(nums, i, j)) {
                    answer++;
                }
            }
        }

        return (int) (answer % (int) (Math.pow(10, 9) + 7));
    }

    private boolean isNicePair(final int[] nums, final int i, final int j) {
        final int num1 = nums[i];
        final int revNum1 = Integer.valueOf(new StringBuilder(String.valueOf(num1)).reverse().toString());
        final int num2 = nums[j];
        final int revNum2 = Integer.valueOf(new StringBuilder(String.valueOf(num2)).reverse().toString());

        return num1 + revNum2 == revNum1 + num2;
    }
}
