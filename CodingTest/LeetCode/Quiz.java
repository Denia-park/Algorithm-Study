package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.largestPerimeter(
                        new int[]{5, 5, 5}
                )
        );
        System.out.println(
                solution.largestPerimeter(
                        new int[]{1, 12, 1, 2, 5, 50, 3}
                )
        );
        System.out.println(
                solution.largestPerimeter(
                        new int[]{5, 5, 50}
                )
        );

    }
}

class Solution {
    public long largestPerimeter(final int[] nums) {
        Arrays.sort(nums);

        long ans = -1;

        //처음에 3개로 값을 구해보고, 계속 조금씩 더하면서 폴리곤이 만들어지는지 체크하고
        //폴리곤이 만들어지면 둘레 값을 구한다.
        long preSum = (long) nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            final int val = nums[i];

            if (preSum > val) {
                ans = preSum + val;
            }

            preSum += val;
        }

        return ans;
    }
}
