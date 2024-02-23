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
    int end;
    int nodeLimit;
    boolean[] isVisited;
    Integer[][] dp;

    public int findCheapestPrice(final int n, final int[][] flights, final int src, final int dst, final int k) {
        graph = new ArrayList<>();
        end = dst;
        nodeLimit = k;
        isVisited = new boolean[n];
        dp = new Integer[n][k + 2];

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

        final int result = dfs(src, 0, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(final int curNode, final int nodeCount, final int costSum) {
        int result = Integer.MAX_VALUE;

        if (curNode == end && nodeCount - 1 <= nodeLimit) {
            return costSum;
        }

        for (final int[] ints : graph.get(curNode)) {
            final int next = ints[0];
            final int cost = ints[1];

            if (isVisited[next] || nodeCount - 1 > nodeLimit) {
                continue;
            }

            if (dp[next][nodeCount] != null) {
                return dp[next][nodeCount];
            }

            isVisited[next] = true;
            final int temp = dfs(next, nodeCount + 1, costSum + cost);
            dp[next][nodeCount] = temp;
            result = Math.min(result, temp);
            isVisited[next] = false;
        }

        return result;
    }
}
