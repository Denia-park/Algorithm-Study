package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numDecodings("12") == 2);
        System.out.println(solution.numDecodings("226") == 3);
        System.out.println(solution.numDecodings("06") == 0);
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
    }
}

class Solution {
    public int numDecodings(final String s) {
        //s가 null 이거나, 길이가 0이거나, 0으로 시작하면 0을 리턴한다.
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        //길이에 대해서 정의
        final int len = s.length();

        //dp 배열 초기화
        final int[] dp = new int[len + 1];
        dp[0] = 1; //dp[0]은 1로 초기화
        dp[1] = 1; //dp[1]은 1로 초기화

        for (int count = 2; count <= len; count++) {
            //한자리 숫자 추가하는 경우
            final int oneDigit = s.charAt(count - 1) - '0';

            //  0으로 시작하면, decode 방법이 없으므로 제외
            if (oneDigit != 0) {
                dp[count] += dp[count - 1];
            }

            //두자리 숫자 추가하는 경우
            final int twoDigit = Integer.parseInt(s.substring(count - 2, count));
            if (10 <= twoDigit && twoDigit <= 26) {
                dp[count] += dp[count - 2];
            }
        }

        return dp[len];
    }
}
