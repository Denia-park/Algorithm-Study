package DFS_And_BFS;


//음료수 얼려 먹기
//N x M 크기의 얼음틀 , 구멍이 뚫려 있는 부분은 0 , 칸막이는 1
//구멍이 뚫려 있는 부분 끼리 상 하 좌 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주
// 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하시오
// 다음의 얼음 틀에서는 아이스크림이 3개가 생성됨
// 00110
// 00011
// 11111
// 00000

//조건
// N , M 은 1이상 1000이하
// 두번쨰 줄 부터 N + 1번째 줄까지는 얼음 틀의 형태가 주어짐
//입력 예시
// 4 5
// 00110
// 00011
// 11111
// 00000

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_And_BFS_Quiz1 {
    //전역변수 graph 를 설정하고 모든 값을 0으로 초기화
    static int n , m; //y , x
    static int[][] graph = new int[5][5]; // 필요하면 필요한 사이즈만큼 크기를 늘리기

    public static void main(String[] args) {
        n = 4; //y
        m = 5; //x
        String[] iceFrame = {
                "00110",
                "00011",
                "11111",
                "00000"
        };

        System.out.println(solve(n, m, iceFrame));

    }

    private static int solve(int n, int m, String[] iceFrames) {
        int answer = 0;
        //iceFrames 받은 것을 내가 가지고 있는 graph 에 맵정보 입력하기
        int index = 0;
        for (String iceFrame : iceFrames) {
            for (int i = 0; i < iceFrame.length(); i++) {
                graph[index][i] = iceFrame.charAt(i) - '0';
            }
            index++;
        }

        System.out.println(Arrays.deepToString(graph));

        //모든 노드(위치)에 관해서 음료수 채우기
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
//                if(bfs(y,x))
//                    answer++;
                if(dfs(y,x))
                    answer++;
            }
        }

        System.out.println(Arrays.deepToString(graph));

        return answer;
    }

     static class Coordinates {
        int y, x;

        Coordinates(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static boolean bfs(int y, int x) {
        //범위를 벗어났을 때 바로 나올 수 있게 조건 설정
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        if(graph[y][x] == 1){
            return false;
        }

        //Queue 만들기
        Queue<Coordinates> queue = new LinkedList<>();

        //노드 집어넣기
        queue.add(new Coordinates(y, x));

        //노드 방문처리
        graph[y][x] = 1;

        //Queue를 비우면서 bfs 처리하기
        while (!queue.isEmpty()) {
            //Queue의 원소를 1개 뽑기
            Coordinates coordinates = queue.poll();

            //coordinates 이름을 다 붙이기에는 너무 길어서 임시 변수 생성
            int tempX = coordinates.x;
            int tempY = coordinates.y;

            //해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            //끝에 도달한 좌표일 경우 OutOfRangeError 를 일으키므로 제외시킴

            //상 : y - 1 이 좌표 조건에서 벗어나지 않고 , 방문하지 않은 좌표면 스택에 넣고 방문처리한다.
            if ((tempY - 1 >= 0) && (graph[tempY - 1][tempX] != 1)){
                graph[tempY - 1][tempX] = 1;
                queue.add(new Coordinates(tempY - 1,tempX));
            }
            //우 : x + 1 이 좌표 조건에서 벗어나지 않고 , 방문하지 않은 좌표면 스택에 넣고 방문처리한다.
            if ((tempX + 1 <= m - 1 ) && (graph[tempY][tempX + 1] != 1)){
                graph[tempY][tempX + 1] = 1;
                queue.add(new Coordinates(tempY ,tempX + 1 ));
            }
            //하 : y + 1 이 좌표 조건에서 벗어나지 않고 , 방문하지 않은 좌표면 스택에 넣고 방문처리한다.
            if ((tempY + 1 <= n - 1) && (graph[tempY + 1][tempX] != 1)){
                graph[tempY + 1][tempX] = 1;
                queue.add(new Coordinates(tempY + 1, tempX ));
            }
            //좌 : x - 1 이 좌표 조건에서 벗어나지 않고 , 방문하지 않은 좌표면 스택에 넣고 방문처리한다.
            if ((tempX - 1 >= 0) && (graph[tempY][tempX - 1] != 1)){
                graph[tempY][tempX - 1] = 1;
                queue.add(new Coordinates(tempY, tempX - 1));
            }
        }

        return true;
    }

    //DFS로 특정 노드를 방문
    //연결된 모든 노드도 같이 방문
    //방문 했으면 1을 기입하는 것으로 방문했음을 표시함
    //x , y는 좌표처럼 생각하자
    private static boolean dfs(int y, int x) {
        //범위를 벗어났을 때 바로 나올 수 있게 조건 설정
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        //방문한 좌표가 1 이 아닌 경우만 1을 넣고 dfs를 이어간다.
            // => 아직 방문하지 않은 곳이라면 방문한다 는 개념
        if(graph[y][x] != 1){
            graph[y][x] = 1;
            //상 , 하 , 좌 , 우 에 있는 모든 위치들도 방문한다.
            //나는 시계방향으로 돌았다.
            dfs(y - 1, x); // 상
            dfs(y, x + 1); // 우
            dfs(y + 1, x); // 하
            dfs(y, x - 1); // 좌

            //방문을 새로 한 곳이므로 true 를 반환하여 answer 값을 올리도록 한다.
            return true;
        }

        return false;
    }
}
