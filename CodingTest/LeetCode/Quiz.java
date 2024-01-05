package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("2 : " + solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println("3 : " + solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}

class Solution {
    public int lengthOfLIS(final int[] nums) {
        final int legnth = nums.length;
        //dp를 사용한다.
        final int[] dp = new int[legnth];
        //모든 부분 수열의 최대 길이는 1이다.
        Arrays.fill(dp, 1);

        //현재 인덱스를 기준으로 이전 인덱스들을 탐색한다.
        for (int curIdx = 1; curIdx < legnth; curIdx++) {
            for (int prevIdx = 0; prevIdx < curIdx; prevIdx++) {
                final int prevValue = nums[prevIdx];
                final int curValue = nums[curIdx];

                //현재 값이 이전 값보다 크다면,
                //이전 값의 dp에 1을 더한 값과 현재 dp를 비교하여 더 큰 값을 현재 dp에 넣는다.
                if (prevValue < curValue) {
                    dp[curIdx] = Math.max(dp[curIdx], dp[prevIdx] + 1);
                }
            }
        }

        //dp의 최대값을 반환한다.
        return Arrays.stream(dp)
                .max()
                .orElse(0);
    }
}
