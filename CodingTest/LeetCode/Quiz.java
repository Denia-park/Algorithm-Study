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

        Arrays.sort(nums);

        int save = 0;

        for (final int num : nums) {
            if (num - save > 1) {
                answer[1] = save + 1;
            } else if (num - save == 0) {
                answer[0] = save;
            }

            if (answer[0] != 0 && answer[1] != 0) {
                break;
            }

            save = num;
        }

        if (answer[1] == 0) {
            answer[1] = nums.length;
        }

        return answer;
    }
}
