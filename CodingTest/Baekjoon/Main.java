package CodingTest.Baekjoon;

//플로이드 11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        String[] edges = new String[busNum];

        for (int i = 0; i < busNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(cityNum, busNum, edges);
    }
}

/*
아이디어
플로이드
- 방향 리스트 정의
- 가중치 값 2차원 배열 초기화
    - 자기 자신은 0, 나머지는 INF, INF는 오버플로우 조심
    - 3차 for문 실행 -> 중간 지점부터 시작할 것 !! 주의

- 출력
배열을 모두 출력
- 자기자신 0 , 못 가면 0

시간복잡도
O(V^3)

자료구조
비용이 10만이하 이므로 모든 도시를 돌아서 int보다 작다.
노선은 하나가 아닐수도 있다. -> 주의
 */

class BjSolution {
    final int INF = (int) Math.pow(10, 9);

    public void solution(int cityNum, int busNum, String[] edges) {
        //방향 리스트 정의
        List<List<Edge>> map = new ArrayList<>();
        for (int i = 0; i < cityNum + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (String edge : edges) {
            String[] split = edge.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);

            map.get(from).add(new Edge(to, weight));
        }

        int[][] arr = new int[cityNum + 1][cityNum + 1];

        //2차원 배열 초기화
        for (int from = 1; from < cityNum + 1; from++) {
            for (int to = 1; to < cityNum + 1; to++) {
                if (from == to) {
                    arr[from][to] = 0;
                    continue;
                }
                arr[from][to] = INF;
            }
        }

        //List 통해서 추가적으로 초기화
        for (int from = 1; from < cityNum + 1; from++) {
            List<Edge> list = map.get(from);
            for (Edge edge : list) {
                int to = edge.to;
                int cost = edge.cost;

                arr[from][to] = Math.min(arr[from][to], cost);
            }
        }

        //floydWarshall
        for (int mid = 1; mid < cityNum + 1; mid++) {
            for (int from = 1; from < cityNum + 1; from++) {
                for (int to = 1; to < cityNum + 1; to++) {
                    if (arr[from][to] > arr[from][mid] + arr[mid][to]) {
                        arr[from][to] = arr[from][mid] + arr[mid][to];
                    }
                }
            }
        }

        //1부터 찍는다
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < cityNum + 1; i++) {
            for (int j = 1; j < cityNum + 1; j++) {
                int val = arr[i][j];
                if (val == INF) val = 0;

                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }
