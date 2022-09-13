package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //노드의 연결 정보를 가지고 있는 List
    List<List<Integer>> graph;
    //방문 정보를 가지고 있는 배열
    boolean[] isVisited;
    //Node 의 수 카운트시에 사용
    int nodeCount;
    //연결이 끊어진 노드의 데이터를 알기 위해서 사용
    int[] disconnectedNode;
    public int solution(int nodeNum, int[][] wires) {
        //graph 선언
        graph = new ArrayList<>();

        //graph 초기화
        for (int i = 0; i < nodeNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //graph의 내용 업데이트
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        //node 차이의 절대값을 가지고 있을 배열
        int[] nodeAbsCount = new int[wires.length];

        //disconnectedNode 조건을 지정하여 dfs를 수행 후 Node 차이의 수를 nodeAbsCount 에 저장
        for (int i = 0; i < wires.length; i++) {
            //disconnectedNode 초기화
            disconnectedNode = wires[i];

            //무조건 1번 노드부터 시작한다.
            int targetNode = 1;

            //처음에 nodeCount 는 0으로 초기화
            nodeCount = 0;
            //isVisited 초기화
            isVisited = new boolean[nodeNum + 1];
            //dfs 수행하면서 node 의 수를 센다. , 1번 노드부터 시작
            dfs(targetNode);

            //여기서 구해진 nodeCount 를 이용하여 절대값의 차이를 nodeAbsCount 에 저장한다.
            nodeAbsCount[i] = Math.abs((nodeNum - nodeCount) - nodeCount);
        }

        //answer는 nodeAbsCount 중 가장 작은 값을 가져야 하므로 처음 초기화는 제일 큰값으로 설정
        int answer = Integer.MAX_VALUE;

        //nodeAbsCount 를 순회하면서 가장 작은 값을 구한다.
        for (int j : nodeAbsCount) {
            answer = Math.min(answer, j);
        }

        return answer;
    }

    private void dfs(int targetNode) {
        //targetNode 에 방문 했으므로 방문 처리
        isVisited[targetNode] = true;
        //방문 처리를 했으므로 nodeCount 를 업데이트
        nodeCount++;

        //for문을 돌면서 방문하지 않은 노드를 방문
        for (int i = 0; i < graph.get(targetNode).size(); i++){
            //방문해야하는 노드 확인
            int newNode = graph.get(targetNode).get(i);

            //연결이 끊어진 노드를 확인하여 continue 처리
            if ((disconnectedNode[0] == targetNode && disconnectedNode[1] == newNode)
                    || (disconnectedNode[0] == newNode && disconnectedNode[1] == targetNode)) {
                continue;
            }

            //방문하지 않은 노드가 있으면 dfs 를 재귀적으로 수행
            if(!isVisited[newNode]){
                dfs(newNode);
            }
        }
    }
}
