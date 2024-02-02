package CodingTest.softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        final int size = line1[0];
        final int manCount = line1[1];
        final int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            final int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            graph[i] = temp;
        }

        final int[][] manPosArr = new int[manCount][2];

        for (int i = 0; i < manCount; i++) {
            final int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

            manPosArr[i] = temp;
        }

        final Solution sol = new Solution();
        sol.solve(graph, manPosArr);
    }
}

class Solution {
    int[][] direcs = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };
    boolean[][] isVisited;
    int tempSum;

    void solve(final int[][] graph, final int[][] manPosArr) {
        isVisited = new boolean[graph.length][graph.length];
        int sum = 0;

        for (final int[] manPos : manPosArr) {
            final int r = manPos[0] - 1;
            final int c = manPos[1] - 1;
            tempSum = -10;

            //최종적으로 갔던 길을 알고있다가 마지막에 isVisited 추가해줘야 함, 그래야 다음 사람이 거기서 수확을 안함
            final List<int[]> lastRoad = new ArrayList<>();
            final Deque<int[]> dq = new ArrayDeque<>(); //경로 저장용
            isVisited[r][c] = true;

            dfs(graph, r, c, graph[r][c], dq, lastRoad);

            //최종적으로 간 길을 isVisited에 추가
            for (final int[] temp : lastRoad) {
                isVisited[temp[0]][temp[1]] = true;
            }
            sum += tempSum;
        }

        System.out.println(sum);
    }


    void dfs(final int[][] graph, final int row, final int col, final int curCollect, final Deque<int[]> saveRoad, final List<int[]> lastRoad) {
        if (saveRoad.size() == 3) {
            if (tempSum < curCollect) {
                tempSum = curCollect;
                lastRoad.clear();
                lastRoad.addAll(saveRoad);
            }
            return;
        }

        //4방향에 대해서 탐색
        for (final int[] direc : direcs) {
            final int nextR = row + direc[0];
            final int nextC = col + direc[1];
            //범위 벗어나면 못감
            if (nextR < 0 || nextR >= graph.length || nextC < 0 || nextC >= graph.length) continue;

            //이미 수확했으면 수확 안함
            saveRoad.addLast(new int[]{nextR, nextC});
            if (isVisited[nextR][nextC]) {
                dfs(graph, nextR, nextC, curCollect, saveRoad, lastRoad);
            } else {
                isVisited[nextR][nextC] = true;
                dfs(graph, nextR, nextC, curCollect + graph[nextR][nextC], saveRoad, lastRoad);
                isVisited[nextR][nextC] = false;
            }
            saveRoad.pollLast();
        }
    }
}
