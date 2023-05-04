package CodingTest.Baekjoon;

//최단경로 - 1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inputs[0]);
        int edgeNum = Integer.parseInt(inputs[1]);
        int startVertex = Integer.parseInt(br.readLine());
        String[] edges = new String[edgeNum];
        for (int i = 0; i < edgeNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(vertexNum, startVertex, edges);
    }
}

class BjSolution {
    int[] weightArray;
    List<List<ConnectVertex>> graph;

    public void solution(int vertexNum, int startVertex, String[] edges) {
        weightArray = new int[vertexNum + 1];
        Arrays.fill(weightArray, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i < vertexNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (String edge : edges) {
            String[] edgeArr = edge.split(" ");

            int from = Integer.parseInt(edgeArr[0]);
            int to = Integer.parseInt(edgeArr[1]);
            int weight = Integer.parseInt(edgeArr[2]);

            graph.get(from).add(new ConnectVertex(to, weight));
        }

        dijkstra(startVertex);

        StringBuilder sb = new StringBuilder();

        //weightArray는 계산을 위해서 인덱스에 + 1을 처리했다.
        for (int i = 1; i < weightArray.length; i++) {
            int tempWeight = weightArray[i];

            if (tempWeight == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(tempWeight);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void dijkstra(int startVertex) {
        PriorityQueue<ConnectVertex> pq = new PriorityQueue<>();

        pq.add(new ConnectVertex(startVertex, 0));
        weightArray[startVertex] = 0;

        while (!pq.isEmpty()) {
            ConnectVertex cur = pq.poll();
            int curVertex = cur.connectVertex;
            int curWeight = cur.weight;

            if (curWeight > weightArray[curVertex]) continue;

            for (ConnectVertex vertex : graph.get(curVertex)) {
                int nextVertex = vertex.connectVertex;
                int nextWeight = vertex.weight;

                if (nextWeight + curWeight < weightArray[nextVertex]) {
                    weightArray[nextVertex] = nextWeight + curWeight;
                    pq.add(new ConnectVertex(nextVertex, nextWeight + curWeight));
                }
            }
        }
    }

    class ConnectVertex implements Comparable<ConnectVertex> {
        int connectVertex;
        int weight;

        public ConnectVertex(int connectVertex, int weight) {
            this.connectVertex = connectVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(ConnectVertex o) {
            return Integer.compare(this.weight, o.weight);
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
