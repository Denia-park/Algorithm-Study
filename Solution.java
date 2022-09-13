package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph;
    boolean[] isVisited;
    int nodeCount;
    int[] disconnectedNode;
    public int solution(int nodeNum, int[][] wires) {
        graph = new ArrayList<>();

        for (int i = 0; i < nodeNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int[] nodeAbsCount = new int[wires.length];

        for (int i = 0; i < wires.length; i++) {
            disconnectedNode = wires[i];

            int targetNode = 1;

            nodeCount = 0;
            isVisited = new boolean[nodeNum + 1];
            dfs(targetNode);

            nodeAbsCount[i] = Math.abs((nodeNum - nodeCount) - nodeCount);
        }

        int answer = Integer.MAX_VALUE;

        for (int j : nodeAbsCount) {
            answer = Math.min(answer, j);
        }

        return answer;
    }

    private void dfs(int targetNode) {
        isVisited[targetNode] = true;
        nodeCount++;

        for (int i = 0; i < graph.get(targetNode).size(); i++){
            int newNode = graph.get(targetNode).get(i);

            if ((disconnectedNode[0] == targetNode && disconnectedNode[1] == newNode)
                    || (disconnectedNode[0] == newNode && disconnectedNode[1] == targetNode)) {
                continue;
            }

            if(!isVisited[newNode]){
                dfs(newNode);
            }
        }
    }
}
