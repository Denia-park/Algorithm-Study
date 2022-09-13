package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph;
    boolean[] isVisited;
    int answer;
    int dfsDeepth;
    public int solution(int nodeNum, int[][] wires) {
        graph = new ArrayList<>();
        answer = -1;

        for (int i = 0; i < nodeNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int targetNode = 1;

        dfsDeepth = 1;
        isVisited = new boolean[nodeNum + 1];
        dfs(targetNode, dfsDeepth);

        System.out.println(dfsDeepth);

        return answer;
    }

    private void dfs(int targetNode, int deepth) {
        dfsDeepth = Math.max(dfsDeepth, deepth);

        for (int i = 0; i < graph.get(targetNode).size(); i++){
            int newNode = graph.get(targetNode).get(i);
            if(!isVisited[newNode]){
                isVisited[newNode] = true;
                int newDeepth = deepth + 1;
                dfs(newNode, newDeepth);
            }
        }
    }
}
