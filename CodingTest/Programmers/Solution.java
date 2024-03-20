package CodingTest.Programmers;

// https://blog.naver.com/gkswlcjs2/223198277102

class Solution {
    public int solution(final int[] sticker) {
        final int length = sticker.length;

        if (length == 1) return sticker[0];
        if (length == 2) return Math.max(sticker[0], sticker[1]);

        final int[] tempSticker = new int[length];
        System.arraycopy(sticker, 0, tempSticker, 0, length);
        tempSticker[length - 1] = 0;

        final int[] tempSticker2 = new int[length];
        System.arraycopy(sticker, 1, tempSticker2, 0, length - 1);

        final int[] dp = new int[length];

        dp[0] = tempSticker[0];
        dp[1] = Math.max(dp[0], tempSticker[1]);

        for (int i = 0; i < length - 2; i++) {
            dp[i + 2] = Math.max(dp[i] + tempSticker[i + 2], dp[i + 1]);
        }

        final int[] dp2 = new int[length];

        dp2[0] = tempSticker2[0];
        dp2[1] = Math.max(dp2[0], tempSticker2[1]);

        for (int i = 0; i < length - 2; i++) {
            dp2[i + 2] = Math.max(dp2[i] + tempSticker2[i + 2], dp2[i + 1]);
        }

        return Math.max(dp[length - 1], dp2[length - 1]);
    }
}
