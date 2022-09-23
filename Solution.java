//정답 코드 참고 : https://small-stap.tistory.com/40
    //DP를 사용함

class Solution {
    int[][] memo;

    public int solution(int[][] board) {
        memo = new int[board.length + 1][board[0].length + 1];
        int lengthOfMaxSide = 0;

        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                if(board[i - 1][j - 1] == 0 ) continue;

                int tempLength = Math.min(memo[i][j - 1], Math.min(memo[i - 1][j], memo[i - 1][j - 1])) + 1;
                lengthOfMaxSide = Math.max(lengthOfMaxSide, tempLength);
                memo[i][j] = tempLength;
            }
        }

        return lengthOfMaxSide * lengthOfMaxSide;
    }
}
