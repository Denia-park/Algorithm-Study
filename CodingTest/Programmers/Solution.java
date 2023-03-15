package CodingTest.Programmers;

import java.util.*;

class Solution {

    private char[][] map;
    private boolean[][] visited;
    private int answer;
    private Map<Character, int[]> mapInfo;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(String[] maps) {
        answer = 0;
        map = new char[maps.length][maps[0].length()];

        mapInfo = new HashMap<>();

        //Data들을 Map으로 변환
        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[r].length(); c++) {
                char data = maps[r].charAt(c);

                if (data == 'S') {
                    mapInfo.put('S', new int[]{r, c});
                } else if (data == 'L') {
                    mapInfo.put('L', new int[]{r, c});
                } else if (data == 'E') {
                    mapInfo.put('E', new int[]{r, c});
                }

                map[r][c] = data;
            }
        }

        visited = new boolean[maps.length][maps[0].length()];
        //S에서 L을 찾는 과정
        bfs('S', 'L');

        //L을 못 찾았으면 그대로 종료
        if (answer == 0) {
            return -1;
        }

        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }

        //L에서 E를 찾는 과정
        bfs('L', 'E');

        return answer == 0 ? -1 : answer;
    }

    private void bfs(char startChar, char targetChar) {
        Deque<Info> deque = new ArrayDeque<>();
        int[] info = mapInfo.get(startChar);
        deque.add(new Info(info[0], info[1], 0));

        while (!deque.isEmpty()) {
            Info tempInfo = deque.poll();
            int r = tempInfo.r;
            int c = tempInfo.c;
            int moveCount = tempInfo.moveCount;

            if (map[r][c] == targetChar) {
                answer += moveCount;
                return;
            }

            visited[r][c] = true;

            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];

                if (isOutOfBound(newR, newC) || map[newR][newC] == 'X')
                    continue;


                if (!visited[newR][newC]) {
                    visited[newR][newC] = true;
                    deque.add(new Info(newR, newC, moveCount + 1));
                }
            }
        }
    }

    private boolean isOutOfBound(int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[0].length;
    }

}

class Info {
    int r;
    int c;
    int moveCount;

    public Info(int r, int c, int moveCount) {
        this.r = r;
        this.c = c;
        this.moveCount = moveCount;
    }
}
