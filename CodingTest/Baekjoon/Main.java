package CodingTest.Baekjoon;

//최소 스패닝 트리 - 1197

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(inputs[0]);
        int edgeNum = Integer.parseInt(inputs[1]);
        String[] edges = new String[edgeNum];
        for (int i = 0; i < edgeNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(vertexNum, edgeNum, edges);
    }
}

class BjSolution {
    final int NODE = 0;
    final int WEIGHT = 1;

    public void solution(int vertexNum, int edgeNum, String[] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < vertexNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (String edge : edges) {
            String[] arr = edge.split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        boolean[] visited = new boolean[vertexNum + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[WEIGHT], o2[WEIGHT]));

        pq.add(new int[]{1, 0});

        int weightSum = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[NODE];
            int weight = cur[WEIGHT];

            if (visited[curNode]) continue;

            weightSum += weight;

            visited[curNode] = true;

            for (int[] nodeInfo : graph.get(curNode)) {
                int nextNode = nodeInfo[NODE];
                int nextWeight = nodeInfo[WEIGHT];

                if (visited[nextNode]) continue;

                pq.add(new int[]{nextNode, nextWeight});
            }
        }

        System.out.println(weightSum);
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
