package UnionFind;

import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int n = 7;
        int m = 11;

        //간선의 비용을 기준으로 PriorityQueue 가 알아서 오름차순 정렬을 함
        Queue<Edge> queue = new PriorityQueue<Edge>();

        queue.add(new Edge(1, 7, 12));
        queue.add(new Edge(1, 4, 28));
        queue.add(new Edge(1, 2, 67));
        queue.add(new Edge(1, 5, 17));
        queue.add(new Edge(2, 4, 24));
        queue.add(new Edge(2, 5, 62));
        queue.add(new Edge(3, 5, 20));
        queue.add(new Edge(3, 6, 37));
        queue.add(new Edge(4, 7, 13));
        queue.add(new Edge(5, 6, 45));
        queue.add(new Edge(5, 7, 73));


        int[] parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int sum = 0;
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            //사이클이 발생하지 않는 경우 그래프에 포함 ( = 즉 서로 연결 해준다 [Union을 해준다.])
            if(!findParent(parents,edge.nodes[0] , edge.nodes[1])){
                unionParent(parents, edge.nodes[0], edge.nodes[1]);
                sum += edge.distance;
            }
        }

        System.out.printf("총 비용은 %d 입니다",sum);
    }

    private static int getParent(int[] parents, int element) {
        int myParent = parents[element];

        if(myParent == element)
            return element;

        return parents[element] = getParent(parents, myParent);
    }

    private static void unionParent(int[] parents, int element1, int element2) {
        int parent1 = getParent(parents,element1);
        int parent2 = getParent(parents, element2);

        if(parent1 < parent2) parents[element2] = parent1;
        else parents[element1] = parent2;

    }

    private static boolean findParent(int[] parents, int element1, int element2) {
        int parent1 = getParent(parents,element1);
        int parent2 = getParent(parents, element2);

        return parent1 == parent2;
    }
}

//간선 클래스
class Edge implements Comparable<Edge> {
    int[] nodes = new int[2];
    int distance;

    public Edge(int nodeA , int nodeB , int distance) {
        this.nodes[0] = nodeA;
        this.nodes[1] = nodeB;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}
