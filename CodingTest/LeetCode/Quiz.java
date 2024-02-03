package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)));
        System.out.println((solution.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)));
        System.out.println((solution.maxSumAfterPartitioning(new int[]{1}, 1)));
    }
}

class Solution {
    public int maxSumAfterPartitioning(final int[] arr, final int k) {
        // 입력 배열의 길이
        final int len = arr.length;

        // dp 테이블 초기화: dp[i]는 배열의 첫 번째 요소부터 i번째 요소까지 나눌 수 있는 최대 합을 저장
        final int[] dp = new int[len + 1];

        // 배열의 각 요소를 순회
        for (int i = 0; i < len; i++) {
            int curMax = 0; // 현재 파티션(부분 배열)의 최대값
            int curSum = 0; // 현재까지 계산된 최대 합

            // 마지막 k개의 요소를 고려하거나 배열의 시작까지 반복
            // 이 반복문은 현재 위치에서 k 크기 내의 모든 가능한 부분 배열을 고려하여 최대 합을 찾음
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                // 현재 파티션 내의 최대값을 업데이트
                curMax = Math.max(curMax, arr[j]);

                // 현재 파티션을 고려한 새로운 합을 계산
                // curMax * (i - j + 1)은 현재 고려 중인 부분 배열의 최대값과 그 크기를 곱한 값
                // dp[j]는 현재 부분 배열 이전까지의 최대 합
                final int curCount = i - j + 1;
                final int sum = (curMax * curCount) + dp[j];

                // 현재까지의 최대 합을 업데이트
                curSum = Math.max(curSum, sum);
            }

            // dp 테이블을 현재 위치에서의 최대 합으로 업데이트
            dp[i + 1] = curSum;
        }

        // dp 테이블의 마지막 요소가 전체 배열을 나눌 수 있는 최대 합을 나타냄
        return dp[len];
    }
}
