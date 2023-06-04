package CodingTest.Baekjoon;

//최단 경로 1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int vNum = Integer.parseInt(split[0]);
        int eNum = Integer.parseInt(split[1]);
        int sNum = Integer.parseInt(br.readLine());

        String[] edges = new String[eNum];

        for (int i = 0; i < eNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(vNum, sNum, edges);
    }
}

/*
아이디어
다익스트라

- 출력
배열을 모두 출력

시간복잡도
O(ELogV)

자료구조
가중치가 10이하의 자연수 이므로 가중치는 int 사용
다익스트라 이므로 PQ 사용
 */

class BjSolution {
    final int INF = (int) Math.pow(10, 9);

    public void solution(int vNum, int sNum, String[] edges) {
        //인접 리스트 사용
        List<List<Edge>> graph = new ArrayList<>();
        //0번째 포함
        for (int i = 0; i < vNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (String edge : edges) {
            String[] split = edge.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);

            //방향 그래프
            graph.get(from).add(new Edge(to, weight));
        }

        //다익스트라 배열 정리
        int[] weights = new int[vNum + 1];
        Arrays.fill(weights, INF);

        weights[sNum] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{sNum, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNum = cur[0];
            int curWeight = cur[1];

            if (weights[curNum] < curWeight) continue;

            for (Edge edge : graph.get(curNum)) {
                int to = edge.to;
                int weight = edge.weight;

                if (weights[to] > curWeight + weight) {
                    weights[to] = curWeight + weight;
                    pq.add(new int[]{to, weights[to]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < weights.length; i++) {
            int val = weights[i];
            if (val == INF) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(val).append("\n");
        }

        System.out.println(sb);
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
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
