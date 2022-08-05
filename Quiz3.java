package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz3 {
    static public void main(String[] args) {

        System.out.println(Arrays.toString(solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1)));
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5)));
//        System.out.println(Arrays.toString(solution(6, new int[][]{{1, 2}, {1, 3}, {2, 5}, {3, 4},{3,6}, {4, 5},{4,6}}, new int[]{2,6,1,4,5}, 5)));
    }

    static ArrayList<ArrayList<Integer>> graph;
    static int answerArrIndex;
    static int dest;
    static int[] visited;
    static int[] answer;
    static public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];

        dest = destination;

        graph = new ArrayList<ArrayList<Integer>>();

        //그래프 초기화 (node랑 Index랑 맞추기 위해서 + 1 해줌)
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //그래프 내용 업데이트, 서로 연결이기 때문에 양쪽으로 연결해준다.
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        visited = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            visited[i] = -1;
        }

        bfs(dest, 0);

        answerArrIndex = 0;
        for (int source : sources) {
            answer[answerArrIndex] = visited[source];

            answerArrIndex++;
        }

        return answer;
    }

    private static void bfs(int source, int distance) {
        Queue<Node> queue = new LinkedList<Node>();

        //집어넣기
        queue.add(new Node(source, distance));
        // visited
        visited[source] = distance;

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();

            ArrayList<Integer> graphOfEachSource = graph.get(tempNode.source);

            for (Integer eachSource : graphOfEachSource) {
                if (visited[eachSource] == -1) {
                    queue.add(new Node(eachSource, tempNode.distance + 1));
                    visited[eachSource] = tempNode.distance + 1;
                }
            }
        }
    }
}

class Node {
    int source;
    int distance;

    public Node(int source, int distance) {
        this.source = source;
        this.distance = distance;
    }
}
