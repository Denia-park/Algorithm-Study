package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findCheapestPrice(4,
                BracketUtil.convertStrToIntArr(
                        "[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]"
                ),
                0, 3, 1));
        System.out.println(solution.findCheapestPrice(3,
                BracketUtil.convertStrToIntArr(
                        "[[0,1,100],[1,2,100],[0,2,500]]"
                ),
                0, 2, 1));
        System.out.println(
                solution.findCheapestPrice(5,
                        BracketUtil.convertStrToIntArr(
                                "[[0,1,100],[1,2,100],[0,2,500]]"
                        ),
                        0, 2, 0)
        );
    }
}

class Solution {
    List<List<int[]>> graph;
    int answer;
    int start;
    int end;
    int nodeLimit;
    boolean[] isVisited;

    public int findCheapestPrice(final int n, final int[][] flights, final int src, final int dst, final int k) {
        answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        start = src;
        end = dst;
        nodeLimit = k;
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (final int[] flight : flights) {
            final int from = flight[0];
            final int to = flight[1];
            final int cost = flight[2];

            graph.get(from).add(new int[]{to, cost});
        }

        isVisited[src] = true;
        dfs(src, 0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(final int curNode, final int nodeCount, final int costSum) {
        if (curNode == end && nodeCount - 1 <= nodeLimit) {
            answer = Math.min(answer, costSum);
            return;
        }

        for (final int[] ints : graph.get(curNode)) {
            final int next = ints[0];
            final int cost = ints[1];

            if (isVisited[next] || nodeCount - 1 > nodeLimit) {
                continue;
            }

            isVisited[next] = true;
            dfs(next, nodeCount + 1, costSum + cost);
            isVisited[next] = false;
        }
    }
}
