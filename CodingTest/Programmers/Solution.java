package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(final int[][] land) {
        int answer = 0;

        final int[][] landCopy = new int[land.length][land[0].length];
        for (final int[] ints : landCopy) {
            Arrays.fill(ints, -1);
        }

        //모든 땅에 대해서 석유량 검사해서 값 넣기
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (isVisited(row, col, landCopy)) {
                    continue;
                }

                bfs(row, col, land, landCopy);
            }
        }

        //수직으로 내려가면서 값을 더해서 제일 큰 값을 사용
        for (int col = 0; col < landCopy[0].length; col++) {
            int tempAnswer = 0;
            boolean checkFlag = true;

            for (int row = 0; row < landCopy.length; row++) {
                if (landCopy[row][col] == 0) {
                    checkFlag = true;
                } else if (checkFlag) {
                    tempAnswer += landCopy[row][col];
                    checkFlag = false;
                }
            }

            answer = Math.max(answer, tempAnswer);
        }

        return answer;
    }

    private void bfs(final int row, final int col, final int[][] land, final int[][] landCopy) {
        final Deque<Point> waitingDeque = new ArrayDeque<>();
        final Deque<Point> deque = new ArrayDeque<>();
        final int startValue = land[row][col];
        landCopy[row][col] = startValue;
        deque.add(new Point(row, col));
        waitingDeque.add(new Point(row, col));

        final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int maxOil = 0;
        while (!deque.isEmpty()) {
            final Point point = deque.poll();
            final int curRow = point.row;
            final int curCol = point.col;

            maxOil++;

            for (final int[] ints : direction) {
                final int nextRow = curRow + ints[0];
                final int nextCol = curCol + ints[1];

                if (isOutOfMap(landCopy, nextRow, nextCol)) {
                    continue;
                }

                if (isVisited(nextRow, nextCol, landCopy)) {
                    continue;
                }

                if (startValue != land[nextRow][nextCol]) {
                    continue;
                }

                landCopy[nextRow][nextCol] = startValue;
                deque.add(new Point(nextRow, nextCol));
                waitingDeque.add(new Point(nextRow, nextCol));
            }
        }

        if (startValue == 0) {
            return;
        }

        for (final Point point : waitingDeque) {
            landCopy[point.row][point.col] = maxOil;
        }
    }

    private boolean isVisited(final int nextRow, final int nextCol, final int[][] landCopy) {
        return landCopy[nextRow][nextCol] != -1;
    }

    private boolean isOutOfMap(final int[][] landCopy, final int nextRow, final int nextCol) {
        return nextRow < 0 || nextRow >= landCopy.length || nextCol < 0 || nextCol >= landCopy[0].length;
    }

    class Point {
        int row;
        int col;

        public Point(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
