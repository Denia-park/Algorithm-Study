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

        //Map 사이즈 체크
        final int[] split = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        final int row = split[0];
        final int col = split[1];

        //남우, 유령, 목표의 좌표를 저장
        final List<int[]> ghosts = new ArrayList<>();
        int[] namwoo = new int[2];
        int[] goal = new int[2];

        final String[][] map = new String[row][col];
        for (int r = 0; r < row; r++) {
            final String[] tempRow = br.readLine().split("");

            for (int c = 0; c < tempRow.length; c++) {
                final String ch = tempRow[c];
                map[r][c] = ch;

                if (ch.equals("N")) { //남우
                    namwoo = new int[]{r, c};
                } else if (ch.equals("G")) { //유령
                    ghosts.add(new int[]{r, c});
                } else if (ch.equals("D")) { //목표
                    goal = new int[]{r, c};
                }
            }
        }

        //namwoo가 목표까지 도착하는데 몇초가 걸리는지 계산한다.
        final int namwooTime = bfs(map, namwoo, false);

        //Comparator에서 goal을 쓰기 위해 final로 지정 (final 변수만이 람다식에서 사용이 가능)
        final int[] finalGoal = goal;
        //모든 유령중에서 가장 목표와 가까운 순으로 유령 좌표를 정렬한다.
        ghosts.sort(
                Comparator.comparingInt(
                        gh -> {
                            final int absRow = Math.abs(finalGoal[0] - gh[0]);
                            final int absCol = Math.abs(finalGoal[1] - gh[1]);

                            return absRow + absCol;
                        }
                )
        );

        //가장 가까운 유령이 목표에 몇초만에 도착하는지 계산한다.
        final int ghostTime = bfs(map, ghosts.get(0), true);

        //남우가 목표에 도착할 수 없으면 No를 출력
        if (namwooTime == -1) {
            System.out.println("No");
            return;
        }

        //남우보다 유령이 먼저 목표에 도착하면, 남우는 탈출이 불가능하다.
        System.out.println(ghostTime <= namwooTime ? "No" : "Yes");
    }

    private static int bfs(final String[][] map, final int[] obj, final boolean isWallPass) {
        //BFS를 쓰기 위해, 옮길 방향을 정의
        final int[][] directions = new int[][]{
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        //방문 좌표 체크용 boolean 배열
        final boolean[][] isVisited = new boolean[map.length][map[0].length];
        //BFS 쓰기 위해 Deque를 정의
        final Deque<int[]> dq = new ArrayDeque<>();
        //초기값 (즉, 유령 혹은 남우의 초기 좌표를 입력)
        dq.addLast(new int[]{obj[0], obj[1], 0});
        //방문 처리
        isVisited[obj[0]][obj[1]] = true;

        //Deque가 빌 때까지, BSF를 수행
        while (!dq.isEmpty()) {
            final int[] cur = dq.pollFirst();
            if (map[cur[0]][cur[1]].equals("D")) { //목표에 도착하면 종료
                return cur[2];
            }

            //4방향을 탐색
            for (final int[] direction : directions) {
                final int nextRow = cur[0] + direction[0];
                final int nextCol = cur[1] + direction[1];

                //범위를 벗어나는지 검사
                if (isOutMap(map, nextRow, nextCol)) {
                    continue;
                }
                //이미 방문했는지 검사
                if (isVisited[nextRow][nextCol]) {
                    continue;
                }
                //벽에 부딪히는지 검사
                if (!isWallPass && map[nextRow][nextCol].equals("#")) {
                    continue;
                }

                //방문 체크
                isVisited[nextRow][nextCol] = true;
                //Deque에 추가
                dq.addLast(new int[]{nextRow, nextCol, cur[2] + 1});
            }
        }

        //탈출하지 못했으면 -1를 리턴
        return -1;
    }

    //Map을 벗어나는지, 아닌지 확인
    private static boolean isOutMap(final String[][] map, final int row, final int col) {
        return row < 0 || row >= map.length || col < 0 || col >= map[0].length;
    }
}
