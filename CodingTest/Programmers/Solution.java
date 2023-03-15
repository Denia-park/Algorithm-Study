package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private char[][] map;
    private boolean[][] visited;
    private Map<Character, int[]> mapInfo;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(String[] maps) {
        int answer = 0;
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

        //S에서 L을 찾는 과정
        visited = new boolean[maps.length][maps[0].length()];
        int rtval = bfs('S', 'L');

        //L을 못 찾았으면 그대로 종료
        if (rtval == 0) return -1;
        answer += rtval;

        //L에서 E를 찾는 과정
        visited = new boolean[maps.length][maps[0].length()];
        rtval = bfs('L', 'E');

        //E를 못 찾았으면 그대로 종료
        if (rtval == 0) return -1;
        answer += rtval;

        return answer;
    }

    private int bfs(char startChar, char targetChar) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] info = mapInfo.get(startChar);
        deque.add(new int[]{info[0], info[1], 0});

        while (!deque.isEmpty()) {
            int[] tempInfo = deque.poll();
            int r = tempInfo[0];
            int c = tempInfo[1];
            int moveCount = tempInfo[2];

            if (map[r][c] == targetChar) {
                return moveCount;
            }

            visited[r][c] = true;

            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];

                if (isOutOfBound(newR, newC) || map[newR][newC] == 'X')
                    continue;


                if (!visited[newR][newC]) {
                    visited[newR][newC] = true;
                    deque.add(new int[]{newR, newC, moveCount + 1});
                }
            }
        }

        return 0;
    }

    private boolean isOutOfBound(int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[0].length;
    }
}
