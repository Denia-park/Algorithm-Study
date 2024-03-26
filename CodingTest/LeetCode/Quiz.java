package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.firstMissingPositive(
                        new int[]{1, 2, 0}
                )
        );

        System.out.println(
                solution.firstMissingPositive(
                        new int[]{3, 4, -1, 1}
                )
        );

        System.out.println(
                solution.firstMissingPositive(
                        new int[]{7, 8, 9, 11, 12}
                )
        );
    }
}

class Solution {
    public int firstMissingPositive(final int[] nums) {
        final int n = nums.length;
        final boolean[] seen = new boolean[n + 1]; // Array for lookup

        // Mark the elements from nums in the lookup array
        for (final int num : nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }

        // Iterate through integers 1 to n
        // return smallest missing positive integer
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        // If seen contains all elements 1 to n
        // the smallest missing positive number is n + 1
        return n + 1;
    }
}
