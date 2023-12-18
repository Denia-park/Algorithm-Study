package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public String[] solution(final int[][] line) {
        final Set<Point> points = new TreeSet<>();

        int smallX = Integer.MAX_VALUE;
        int bigX = Integer.MIN_VALUE;
        int smallY = Integer.MAX_VALUE;
        int bigY = Integer.MIN_VALUE;

        //모든 교점 구하기
        for (int i = 0; i < line.length; i++) {
            final int[] origin = line[i];

            for (int j = i + 1; j < line.length; j++) {
                int pointX = 0;
                int pointY = 0;

                final int originX = origin[0];
                final int originY = origin[1];
                final int originC = origin[2];

                final int[] target = line[j];
                final int targetX = target[0];
                final int targetY = target[1];
                final int targetC = target[2];

                //x 구하기
                //  작은 y 구하기.
                // 절대 값이 작은 걸로 구하기
                if (Math.abs(originY) < Math.abs(targetY)) {
                    double divide;

                    if (originY == 0) {
                        divide = -1 * (double) originC / originX;
                    } else {
                        divide = (double) targetY / originY;

                        final double newTargetX = targetX - originX * divide;
                        final double newTargetC = (targetC - originC * divide);

                        divide = -1 * newTargetC / newTargetX;
                    }

                    if (isNotInteger(divide)) {
                        continue;
                    }

                    pointX = (int) divide;
                } else {
                    double divide;

                    if (targetY == 0) {
                        divide = -1 * (double) targetC / targetX;
                    } else {
                        divide = (double) originY / targetY;

                        final double newOriginX = originX - targetX * divide;
                        final double newOriginC = originC - targetC * divide;

                        divide = -1 * newOriginC / newOriginX;
                    }

                    if (isNotInteger(divide)) {
                        continue;
                    }

                    pointX = (int) divide;
                }

                //y 구하기
                if (originY == 0) {
                    continue;
                }

                final double tempY = (-1 * (double) (originC + originX * pointX) / originY);

                if (isNotInteger(tempY)) {
                    continue;
                }

                pointY = (int) tempY;

                //최소, 최대 x, y 구하기
                bigX = Math.max(bigX, pointX);
                smallX = Math.min(smallX, pointX);
                bigY = Math.max(bigY, pointY);
                smallY = Math.min(smallY, pointY);

                points.add(new Point(pointX, pointY));
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
        for (final Point point : points) {
            map[bigY - point.y][point.x - smallX] = '*';
        }

        //정답 구하기
        final String[] answer = new String[row];
        for (int i = 0; i < row; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }

    private boolean isNotInteger(final double divide) {
        return Math.floor(divide) != divide;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(final Point o) {
            if (this.x == o.x) {
                return -1 * (this.y - o.y);
            }

            return this.x - o.x;
        }
    }
}
