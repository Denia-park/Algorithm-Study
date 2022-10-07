package DFS_And_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class DFS_And_BFS_Quiz2 {
    static int[][] graph = new int[6][6]; // 필요하면 필요한 사이즈만큼 크기를 늘리기
    static int height;
    static int width;

    static int answer;

    public static void main(String[] args) {
        height = 5;
        width = 6;
        String[] maze = {
                "101010",
                "111111",
                "000001",
                "111111",
                "111111"
        };

        System.out.println(solve(height, width, maze));

    }

    private static int solve(int localHeight, int localWidth, String[] maze) {
        answer = 0;
        int index = 0;
        for (String mazeRow : maze) {
            for (int i = 0; i < mazeRow.length(); i++) {
                graph[index][i] = mazeRow.charAt(i) - '0';
            }
            index++;
        }

        return bfs(0, 0);
    }

    private static int bfs(int y, int x) {
        Queue<Coordinates> queue = new LinkedList<Coordinates>();

        int distance = 0;
        //집어넣기
        queue.add(new Coordinates(y, x , distance));

        //Visited 처리
        graph[y][x] = 0;

        while (!queue.isEmpty()) {
            Coordinates coordinates = queue.poll();
            int tempX = coordinates.x;
            int tempY = coordinates.y;
            int tempDistance = coordinates.distance;

            if(tempX == width - 1 && tempY == height - 1) {
                return tempDistance + 1;
            }

            //상 하 좌 우 돌면서 스택에 넣기.
            if(tempY - 1 > -1 && graph[tempY - 1][tempX] != 0){
                queue.add(new Coordinates(tempY - 1, tempX, tempDistance + 1));
                graph[tempY - 1][tempX] = 0;
            }

            if(tempY + 1 < height && graph[tempY + 1][tempX] != 0){
                queue.add(new Coordinates(tempY + 1, tempX, tempDistance + 1));
                graph[tempY + 1][tempX] = 0;
            }

            if(tempX - 1 > -1 && graph[tempY][tempX-1] != 0){
                queue.add(new Coordinates(tempY, tempX - 1, tempDistance + 1));
                graph[tempY][tempX-1] = 0;
            }

            if(tempX + 1 < width && graph[tempY][tempX+1] != 0){
                queue.add(new Coordinates(tempY, tempX + 1, tempDistance + 1));
                graph[tempY][tempX+1] = 0;
            }
        }

        return -1;
    }
}

class Coordinates {
    int x, y;
    int distance;

    public Coordinates(int y, int x, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
