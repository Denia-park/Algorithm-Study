package CodingTest.Programmers;

/*
아이디어 - DFS
네트워크 개수 구하기
 */

class Solution {
    public int solution(final int n, final int[][] computers) {
        int answer = 0;
        final boolean[] isVisited = new boolean[n];

        //네트워크 파악을 위해 0 ~ n-1 까지 순회
        for (int start = 0; start < n; start++) {
            if (isVisited[start]) continue;

            dfs(computers, isVisited, start);
            answer++;
        }

        return answer;
    }

    private void dfs(final int[][] computers, final boolean[] isVisited, final int start) {
        isVisited[start] = true;
        final int[] computer = computers[start];

        for (int next = 0; next < computer.length; next++) {
            final int isAble = computer[next];
            if (isVisited[next] || isAble == 0) continue;

            isVisited[next] = true;
            dfs(computers, isVisited, next);
        }
    }
}
