package CodingTest.Baekjoon;

//불! 4179

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(final String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int[] line1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        final int sizeRow = line1[0];
        final int sizeCol = line1[1];

        final String[][] map = new String[sizeRow][sizeCol];

        for (int i = 0; i < sizeRow; i++) {
            final String[] tempLine = br.readLine().split("");
            map[i] = tempLine;
        }

        final Solution sol = new Solution();
        sol.solve(map);
    }
}

class Solution {
    String WALL = "#";
    String EMPTY = ".";
    String FIRE = "F";
    String JH = "J";

    int FIRE_NUM = 4;
    int JH_NUM = 3;

    int[][] direcs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    void solve(final String[][] map) {
        int answer = Integer.MAX_VALUE;

        final int totalR = map.length;
        final int totalC = map[0].length;

        final int[] jihun = new int[4];
        final List<int[]> fires = new ArrayList<>();

        //불 및 지훈이 어딨는지 탐색
        for (int r = 0; r < totalR; r++) {
            for (int c = 0; c < totalC; c++) {
                if (map[r][c].equals("F")) {
                    final int[] fire = new int[4];

                    fire[0] = r;
                    fire[1] = c;
                    fire[2] = 0;
                    fire[3] = FIRE_NUM;

                    fires.add(fire);
                } else if (map[r][c].equals("J")) {
                    jihun[0] = r;
                    jihun[1] = c;
                    jihun[2] = 0; //count
                    jihun[3] = JH_NUM;
                }
            }
        }

        //지훈 이동
        //불 이동
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.addAll(fires);//불
        dq.addLast(jihun);//지훈

        while (!dq.isEmpty()) {
            final int[] cur = dq.pollFirst();

            //지훈인지 불인지 확인
            if (cur[3] == JH_NUM) {
                for (final int[] direc : direcs) {
                    final int nextR = cur[0] + direc[0];
                    final int nextC = cur[1] + direc[1];
                    //지훈인데 현재 값이 밖으로 나갔으면 통과
                    if (nextR < 0 || nextR >= totalR || nextC < 0 || nextC >= totalC) {
                        answer = Math.min(answer, cur[2] + 1);
                        continue;
                    }

                    if (!map[nextR][nextC].equals(EMPTY)) continue;

                    dq.addLast(new int[]{nextR, nextC, cur[2] + 1, JH_NUM});
                    map[nextR][nextC] = JH;
                }
            } else { //불
                for (final int[] direc : direcs) {
                    final int nextR = cur[0] + direc[0];
                    final int nextC = cur[1] + direc[1];
                    //불이므로 그냥 4방향으로 퍼짐
                    if (nextR < 0 || nextR >= totalR || nextC < 0 || nextC >= totalC) {
                        continue;
                    }

                    if (map[nextR][nextC].equals(WALL) || map[nextR][nextC].equals(FIRE)) continue;

                    dq.addLast(new int[]{nextR, nextC, cur[2] + 1, FIRE_NUM});
                    map[nextR][nextC] = FIRE;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
    }
}
