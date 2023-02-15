package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    boolean[][] isVisited;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] map;
    private int rowNum;
    private int colNum;

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        rowNum = maps.length;
        colNum = maps[0].length();

        map = new int[rowNum][colNum];
        isVisited = new boolean[rowNum][colNum];

        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                char ch = maps[r].charAt(c);

                map[r][c] = ch == 'X' ? -1 : ch - '0';
            }
        }

        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (map[r][c] == -1 || isVisited[r][c]) continue;

                answer.add(bfs(r, c));
            }
        }

        return answer.size() == 0 ? new int[]{-1} : answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int bfs(int r, int c) {
        int sumVal = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{r, c});
        isVisited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            sumVal += map[curr[0]][curr[1]];

            for (int[] direction : directions) {
                int rNext = curr[0] + direction[0];
                int cNext = curr[1] + direction[1];

                if (rNext < 0 || rNext >= rowNum
                        || cNext < 0 || cNext >= colNum
                        || isVisited[rNext][cNext]
                        || map[rNext][cNext] == -1) continue;

                queue.addLast(new int[]{rNext, cNext});
                isVisited[rNext][cNext] = true;
            }
        }

        return sumVal;
    }
}
