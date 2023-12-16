package CodingTest.Programmers;

import java.util.*;

class Solution {
    public int solution(final int[][] land) {
        int answer = 0;

        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int countIndex = 500000;

        //모든 땅에 대해서 석유량 검사해서 값 넣기
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (isVisited(col, land[row])) {
                    continue;
                }

                final int maxOil = bfs(row, col, land, countIndex);
                map.put(countIndex, maxOil);
                countIndex++;
            }
        }

        //수직으로 내려가면서 값을 더해서 제일 큰 값을 사용
        for (int col = 0; col < land[0].length; col++) {
            final Set<Integer> set = new HashSet<>();
            int tempAnswer = 0;

            for (final int[] ints : land) {
                final int tempIdx = ints[col];

                if (set.contains(tempIdx)) {
                    continue;
                }

                tempAnswer += map.get(tempIdx);
                set.add(tempIdx);
            }

            answer = Math.max(answer, tempAnswer);
        }

        return answer;
    }

    private int bfs(final int row, final int col, final int[][] land, final int countIndex) {
        final Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(row, col));
        land[row][col] = countIndex;

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

                if (isOutOfMap(land, nextRow, nextCol) || isVisited(nextCol, land[nextRow])) {
                    continue;
                }

                deque.add(new Point(nextRow, nextCol));
                land[nextRow][nextCol] = countIndex;
            }
        }

        return maxOil;
    }

    private boolean isVisited(final int col, final int[] rowLand) {
        return rowLand[col] != 1;
    }

    private boolean isOutOfMap(final int[][] land, final int nextRow, final int nextCol) {
        return nextRow < 0 || nextRow >= land.length || nextCol < 0 || nextCol >= land[0].length;
    }

    static class Point {
        int row;
        int col;

        public Point(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
