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
    public static final String WALL = "#";
    public static final String EMPTY = ".";
    public static final String FIRE = "F";
    public static final String JH = "J";

    public static final int FIRE_NUM = 4;
    public static final int JH_NUM = 3;

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

        //불 이동
        //지훈 이동
        final Deque<int[]> dq = new ArrayDeque<>(fires);//불
        dq.addLast(jihun);//지훈

        while (!dq.isEmpty()) {
            final int[] cur = dq.pollFirst();

            //지훈인지 불인지 확인
            for (final int[] direc : direcs) {
                final int nextR = cur[0] + direc[0];
                final int nextC = cur[1] + direc[1];
                final int checkNum = cur[3];


                if (isOutOfMap(nextR, totalR, nextC, totalC)) {
                    //지훈인데 현재 값이 밖으로 나갔으면 통과
                    if (checkNum == JH_NUM) {
                        answer = Math.min(answer, cur[2] + 1);
                    }

                    continue;
                }

                if (checkNum == JH_NUM) {
                    if (!map[nextR][nextC].equals(EMPTY)) continue;

                    dq.addLast(new int[]{nextR, nextC, cur[2] + 1, JH_NUM});
                    map[nextR][nextC] = JH;
                } else {
                    if (map[nextR][nextC].equals(WALL) || map[nextR][nextC].equals(FIRE)) continue;

                    dq.addLast(new int[]{nextR, nextC, cur[2] + 1, FIRE_NUM});
                    map[nextR][nextC] = FIRE;
                }
            }

            if (answer != Integer.MAX_VALUE) break;
        }

        System.out.println(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
    }

    private boolean isOutOfMap(final int nextR, final int totalR, final int nextC, final int totalC) {
        return nextR < 0 || nextR >= totalR || nextC < 0 || nextC >= totalC;
    }
}
