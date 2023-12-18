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
                int pointX = 0;
                int pointY = 0;

                final int originA = origin[0];
                final int originB = origin[1];
                final int originE = origin[2];

                final int[] target = line[j];
                final int targetC = target[0];
                final int targetD = target[1];
                final int targetF = target[2];

                final long mod = (long) originA * targetD - (long) originB * targetC;

                //평행
                if (mod == 0) {
                    continue;
                }

                //교점 구하기
                final long xValue = (long) originB * targetF - (long) originE * targetD;
                final long yValue = (long) originE * targetC - (long) originA * targetF;

                //정수 인지 확인하기
                if (xValue % mod != 0 || yValue % mod != 0) {
                    continue;
                }

                pointX = (int) (xValue / mod);
                pointY = (int) (yValue / mod);

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
