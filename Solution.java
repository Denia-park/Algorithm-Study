//정답 코드 참조 : https://shanepark.tistory.com/183

public class Solution {
    int solution(int[][] land) {
        final int length = land.length;

        for (int i = 1; i < length; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][1], land[i - 1][3], land[i - 1][0]);
            land[i][3] += max(land[i - 1][1], land[i - 1][2], land[i - 1][0]);
        }

        return max(land[length - 1]);
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int max(int[] arr) {
        int max = 0;
        for(int number : arr) {
            max = Math.max(max, number);
        }
        return max;
    }
}
