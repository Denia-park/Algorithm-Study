package com.company;

import java.util.*;

// 참고 유튜브 : https://youtu.be/7C9RgOcvkvo

//DFS : 깊이 우선 탐색 (그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘)
//DFS 는 스택 자료구조 (혹은 재귀 함수)를 이용
    //1. 탐색 시작 노드를 스택에 삽입 방문 처리
    //2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문 처리
    //방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼냅니다.
    //3. 더 이상 2번의 과정을 수행할 수 없을 때 까지 반복합니다.

//BFS : 너비 우선 탐색 (그래프에서 가까운 노드부터 우선적으로 탐색하는 알고리즘)
//BFS 는 큐 자료구조 를 이용
    //1. 탐색 시작 노드를 큐에 삽입 후 방문 처리
    //2. 큐에서 노드를 꺼낸 뒤에 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입 후 방문 처리
    //3. 더 이상 2번의 과정을 수행할 수 없을 때 까지 반복합니다.
//특정 조건에서 최단 경로 문제에 효과적

public class DFS_And_BFS {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }

    // BFS 함수 정의
    //결과가 1 2 3 8 7 4 5 6 이렇게 나오는데
    //  2 3 8 : 거리가 1
    //  7 4 5 : 거리가 2
    //  6 : 거리가 3
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        //Queue 에다가 노드를 집어넣기.
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        makeGraph(graph);
//
//        //둘 중에 1개만 사용
//        dfs(1);
//        bfs(1);
//    }

    private static void makeGraph(ArrayList<ArrayList<Integer>> graph) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);
    }
}



