class Solution {
    final int ROW = 0;
    final int COL = 1;
    final int ROW_COL = 2;
    int gSize;
    int answer;
    int[][] gTable;

    public int solution(int size, int[][] table) {
        answer = 0;
        gSize = size;
        gTable = table;

        dfs(1, 2, 0);

        return answer;
    }

    private void dfs(int x, int y, int direction) {
        if (x == gSize && y == gSize) { // 종료 조건
            answer++;
            return;
        }

        switch (direction) {
            case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선임.
                if (y + 1 <= gSize && gTable[x][y + 1] == 0) { // 동쪽
                    dfs(x, y + 1, 0);
                }
                break;
            case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선임.
                if (x + 1 <= gSize && gTable[x + 1][y] == 0) { // 남쪽
                    dfs(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
                if (y + 1 <= gSize && gTable[x][y + 1] == 0) { // 동쪽
                    dfs(x, y + 1, 0);
                }

                if (x + 1 <= gSize && gTable[x + 1][y] == 0) { // 남쪽
                    dfs(x + 1, y, 1);
                }
                break;
        }

        // 파이프가 어떤 방향이든지, 대각선은 검사해서 가장 아래로 뺐음.
        if (y + 1 <= gSize && x + 1 <= gSize && gTable[x][y + 1] == 0 && gTable[x + 1][y] == 0 && gTable[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
