import java.util.Arrays;

class Solution {
    int gStart;
    int gEnd;
    int answer;
    boolean[] primeTable;
    boolean[][] visited;

    public void solution(int size, int[][] table) {
        int answer = 0;

        primeTable = new boolean[10000];
        Arrays.fill(primeTable, true);

        eratosthenes(primeTable);

        for (int i = 0; i < size; i++) {
            int[] quiz = table[i];
            gStart = quiz[0];
            gEnd = quiz[1];
            answer = 0;
            visited = new boolean[4][10];

            dfs(gStart, 0);

            System.out.println(answer);
        }
    }

    void dfs(int curValue, int count) {
        if (curValue == gEnd) {
            answer = Math.min(answer, count);
            return;
        }

        StringBuilder sb = new StringBuilder("" + curValue);

        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 0) continue;

                if (visited[i][j]) continue;

                visited[i][j] = true;
                sb.replace(i, i + 1, String.valueOf(j));
                int newValue = Integer.parseInt(sb.toString());
                if (!primeTable[newValue]) continue;
                dfs(newValue, count + 1);
            }
        }
    }

    private void eratosthenes(boolean[] primeTable) {
        for (int i = 2; i < 10000; i++) {
            if (!primeTable[i]) {
                continue;
            }
            for (int j = i + i; j < 10000; j += i) {
                primeTable[j] = false;
            }
        }
    }
}
