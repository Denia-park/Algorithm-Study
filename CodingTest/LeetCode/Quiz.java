package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}) == 2);
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}) == 3);
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}) == 5);
        System.out.println(solution.maximumElementAfterDecrementingAndRearranging(new int[]{15}) == 1);
    }
}

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(final int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[arr.length - 1];
    }
}
