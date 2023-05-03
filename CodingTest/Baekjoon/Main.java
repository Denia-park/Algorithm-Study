package CodingTest.Baekjoon;

//최소 스패닝 트리 - 1197

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

        for (String edge : edges) {
            String[] arr = edge.split(" ");
            int from = Integer.parseInt(arr[0]);
            int to = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);

            pq.add(new Edge(from, to, weight));
        }

        int[] parents = new int[vertexNum + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int weightSum = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int from = cur.from;
            int to = cur.to;
            int weight = cur.weight;

            if (findParent(parents, from, to)) {
                continue;
            }

            weightSum += weight;
            unionParent(parents, from, to);
        }

        System.out.println(weightSum);
    }

    private boolean findParent(int[] parents, int from, int to) {
        return getParent(parents, from) == getParent(parents, to);
    }

    private int getParent(int[] parents, int node) {
        int myParent = parents[node];

        if (node == myParent) return node;

        int myParentParent = getParent(parents, myParent);
        parents[node] = myParentParent;
        return myParentParent;

    }

    private void unionParent(int[] parents, int from, int to) {
        int fromParent = getParent(parents, from);
        int toParent = getParent(parents, to);

        if (fromParent == toParent) return;

        if (fromParent < toParent) {
            parents[toParent] = fromParent;
        } else {
            parents[fromParent] = toParent;
        }
    }

    class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
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
