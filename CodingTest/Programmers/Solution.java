package CodingTest.Programmers;

class Solution {
    public int solution(final int[] sticker) {
        final int n = sticker.length;
        final int[] dp1 = new int[n];
        final int[] dp2 = new int[n];

        if (n == 1)
            return sticker[0];

        //첫번째 스티커를 뜯었을 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for (int i = 2; i < n; i++) {
            int stickerVal = sticker[i];

            //첫번째 스티커를 뜯으면, 마지막 sticker는 0이다. (뜯을 수 없으므로)
            if (i == (n - 1)) {
                stickerVal = 0;
            }

            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + stickerVal);
        }

        //첫번째 스티커를 뜯지 않았을 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
