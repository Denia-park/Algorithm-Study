package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(final int[][] line) {
        int smallX = Integer.MAX_VALUE;
        int bigX = Integer.MIN_VALUE;
        int smallY = Integer.MAX_VALUE;
        int bigY = Integer.MIN_VALUE;

        final List<int[]> points = new ArrayList<>();

        //모든 교점 구하기
        for (int i = 0; i < line.length; i++) {
            final int[] origin = line[i];

            for (int j = i + 1; j < line.length; j++) {
                final int[] target = line[j];

                final long mod = ((long) origin[0] * target[1]) - ((long) origin[1] * target[0]);

                //평행
                if (mod == 0) {
                    continue;
                }

                //교점 구하기
                final long xValue = ((long) origin[1] * target[2]) - ((long) origin[2] * target[1]);
                final long yValue = ((long) origin[2] * target[0]) - ((long) origin[0] * target[2]);

                //정수 인지 확인하기
                if (xValue % mod != 0 || yValue % mod != 0) {
                    continue;
                }

                final int pointX = (int) (xValue / mod);
                final int pointY = (int) (yValue / mod);

                //최소, 최대 x, y 구하기
                bigX = Math.max(bigX, pointX);
                smallX = Math.min(smallX, pointX);
                bigY = Math.max(bigY, pointY);
                smallY = Math.min(smallY, pointY);

                points.add(new int[]{pointX, pointY});
            }
        }

        //좌표를 기준으로 다른 좌표들과의 거리 구하기
        final int row = bigY - smallY + 1;
        final int col = bigX - smallX + 1;
        final char[][] map = new char[row][col];
        for (final char[] chars : map) {
            Arrays.fill(chars, '.');
        }

        //그림 그리기
        for (final int[] point : points) {
            map[bigY - point[1]][point[0] - smallX] = '*';
        }

        //정답 구하기
        final String[] answer = new String[row];
        for (int i = 0; i < row; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}
