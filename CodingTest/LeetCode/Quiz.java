package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + Arrays.toString(solution.findErrorNums(
                new int[]{1, 2, 2, 4}
        )));
        System.out.println("2 : " + Arrays.toString(solution.findErrorNums(
                new int[]{1, 1}
        )));
    }
}

class Solution {
    public int[] findErrorNums(final int[] nums) {
        final int[] answer = new int[2];

        final int[] countArray = new int[nums.length + 1];

        for (final int num : nums) {
            countArray[num]++;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (countArray[i] == 0) {
                answer[1] = i;
            } else if (countArray[i] == 2) {
                answer[0] = i;
            }
        }

        return answer;
    }
}
