package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph;
    int[] finfo;

    public int solution(final int[] info, final int[][] edges) {
        finfo = info;
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (final int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        final List<Integer> nextNodes = new ArrayList<>(graph.get(0));

        final int sheep = 0;
        final int wolf = 0;
        final int curNode = 0;
        return dfs(sheep, wolf, curNode, nextNodes);
    }

    private int dfs(final int sheep, final int wolf, final int curNode, final List<Integer> nextNodes) {
        int tempSheep = 0;
        int tempWolf = 0;

        if (finfo[curNode] == 0) tempSheep++;
        else tempWolf++;

        if (sheep + tempSheep <= wolf + tempWolf) {
            return sheep;
        }

        int answer = sheep + tempSheep;

        for (final Integer nextNode : nextNodes) {
            final List<Integer> newNextNodes = new ArrayList<>(nextNodes);
            newNextNodes.remove(nextNode);
            newNextNodes.addAll(graph.get(nextNode));

            answer = Math.max(answer, dfs(sheep + tempSheep, wolf + tempWolf, nextNode, newNextNodes));
        }

        return answer;
    }
}
