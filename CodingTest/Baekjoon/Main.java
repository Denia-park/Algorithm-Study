package CodingTest.Baekjoon;

//플로이드 - 11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        String[] edges = new String[edgeNum];
        for (int i = 0; i < edgeNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(nodeNum, edges);
    }
}

/*
1. 아이디어
플로이드-워셜

2. 시간 복잡도
시작 - 중간 - 끝 => 모든 노드를 대상으로 해서 모든 경우의 수를 구한다. [ V ^ 3 ]

3. 자료 구조
모든 경로를 저장할 2차원 배열 int[][]

4. 주의할점
시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
같은 노선인데 비용이 여러개가 있다. 그러므로 더 싼 노선으로만 업데이트를 해야한다.
*/

class BjSolution {
    int[][] weights;
    int INF = (int) Math.pow(10, 9);

    public void solution(int nodeNum, String[] edges) {
        //weights 선언
        weights = new int[nodeNum + 1][nodeNum + 1];

        //weights 를 INF로 초기화
        for (int[] weight : weights) {
            Arrays.fill(weight, INF);
        }
        //자기 자신한테 가는 버스는 비용이 0
        for (int i = 0; i < weights.length; i++) {
            weights[i][i] = 0;
        }

        //edges를 읽으면서 비용 업데이트
        for (String edge : edges) {
            String[] inputs = edge.split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            weights[from][to] = Math.min(weights[from][to], weight);
        }

        //3중 for문 돌면서 거리 업데이트
        floydWarshall();


        //출력
        //시작 노드 인덱스는 1번부터 시작하자
        for (int start = 1; start < weights.length; start++) {
            for (int end = 1; end < weights.length; end++) {
                int weight = weights[start][end];
                System.out.printf("%d ", weight == INF ? 0 : weight);
            }
            System.out.println();
        }
    }

    private void floydWarshall() {
        for (int wayPoint = 1; wayPoint < weights.length; wayPoint++) {
            for (int start = 1; start < weights.length; start++) {
                for (int end = 1; end < weights.length; end++) {
                    weights[start][end] = Math.min(weights[start][end], weights[start][wayPoint] + weights[wayPoint][end]);
                }
            }
        }
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
