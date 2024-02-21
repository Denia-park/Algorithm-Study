package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static final int DONUT = 0;
    private static final int BLOCK = 1;
    private static final int EIGHT = 2;
    private Map<Integer, Node> map;

    public int[] solution(final int[][] edges) {
        final int[] answer = new int[4];

        map = new HashMap<>();

        //정점을 저장
        for (final int[] edge : edges) {
            final int from = edge[0];
            final int to = edge[1];

            //out 증가
            final Node fromNode = map.computeIfAbsent(from, Node::new);
            fromNode.outCnt++;
            fromNode.add(to);


            //in 증가
            final Node toNode = map.computeIfAbsent(to, Node::new);
            toNode.inCnt++;
        }

        //정점 찾기
        final Node rootNode = map.values().stream()
                .filter(node -> node.outCnt >= 2 && node.inCnt == 0)
                .findFirst().get();

        answer[0] = rootNode.num;

        for (final Integer startNum : rootNode.outNums) {
            final int idx = dfs(startNum, true, startNum);
            answer[idx + 1]++;
        }

        return answer;
    }

    private int dfs(final Integer startNum, final boolean isFirstNode, final int curNum) {
        //8자 인지 확인하기
        final Node curNode = map.get(curNum);
        if (curNode.inCnt >= 2 && curNode.outCnt >= 2) {
            return EIGHT;
        }

        //처음이 아닌데, 자기 자신을 다시 만나면 도넛
        if (!isFirstNode && startNum == curNum) {
            return DONUT;
        }

        //더 이상 못가면 막대
        final List<Integer> outNums = map.get(curNum).outNums;
        if (outNums.isEmpty()) {
            return BLOCK;
        }

        return dfs(startNum, false, outNums.get(0));
    }

    class Node {
        int num;
        int inCnt;
        int outCnt;
        List<Integer> outNums = new ArrayList<>();

        public Node(final int num) {
            this.num = num;
        }

        void add(final int val) {
            outNums.add(val);
        }
    }
}
