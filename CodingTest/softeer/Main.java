package CodingTest.softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
유령은 먼저 입구로 가서, 입구를 막으면 됨
-> 유령 도착시간이 남우보다 빠르면, 남우는 절대 탈출 못함

4 6
.....D
......
.GN#..
G.....

4 6
...#.D
...#..
.GN#..
G.....
 */

public class Main {
    public static void main(final String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[] split = convertInts(br.readLine().split(" "));
        final int row = split[0];
        final int col = split[1];

        final String[] map = new String[row];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine();
        }

        //좌표
        final List<int[]> ghosts = new ArrayList<>();
        int[] namwoo = new int[2];

        for (int r = 0; r < map.length; r++) {
            final String line = map[r];

            final char[] charArray = line.toCharArray();

            for (int c = 0; c < charArray.length; c++) {
                final char ch = charArray[c];
                if (ch == 'N') { //남우
                    namwoo = new int[]{r, c};
                } else if (ch == 'G') {
                    ghosts.add(new int[]{r, c});
                }
            }
        }

        //namwoo
        final int namwooTime = bfs(map, namwoo, false);

        int ghostTime = Integer.MAX_VALUE;
        for (final int[] ghost : ghosts) {
            ghostTime = Math.min(ghostTime, bfs(map, ghost, true));
        }

        if (namwooTime == -1) {
            System.out.println("No");
            return;
        }

        System.out.println(ghostTime <= namwooTime ? "No" : "Yes");
    }

    private static int bfs(final String[] map, final int[] obj, final boolean isWallPass) {
        final int[][] directions = new int[][]{
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        final boolean[][] isVisited = new boolean[map.length][map[0].length()];
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{obj[0], obj[1], 0});
        isVisited[obj[0]][obj[1]] = true;

        while (!dq.isEmpty()) {
            final int[] cur = dq.pollFirst();
            if (map[cur[0]].charAt(cur[1]) == 'D') {
                return cur[2];
            }

            for (final int[] direction : directions) {
                final int nextRow = cur[0] + direction[0];
                final int nextCol = cur[1] + direction[1];

                //범위를 벗어나는지,
                if (isOut(map, nextRow, nextCol)) {
                    continue;
                }
                //이미 방문했는지 검사
                if (isVisited[nextRow][nextCol]) {
                    continue;
                }
                //벽에 부딪히는지 검사
                if (!isWallPass && map[nextRow].charAt(nextCol) == '#') {
                    continue;
                }

                dq.addLast(new int[]{nextRow, nextCol, cur[2] + 1});
            }
        }

        return -1;
    }

    private static boolean isOut(final String[] map, final int row, final int col) {
        return row < 0 || row >= map.length || col < 0 || col >= map[0].length();
    }

    private static int[] convertInts(final String[] s) {
        return Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
    }
}

