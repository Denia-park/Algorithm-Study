package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    boolean[] isVisited;

    public int findCheapestPrice(final int n, final int[][] flights, final int src, final int dst, final int k) {
        graph = new ArrayList<>();
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (final int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        final int result = bfs(src, dst, k);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int bfs(final int src, final int dst, final int k) {
        int result = Integer.MAX_VALUE;

        final Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{src, 0, 0});
        isVisited[src] = true;

        while (!dq.isEmpty()) {
            final int[] curVal = dq.pollFirst();
            final int curNode = curVal[0];
            final int cost = curVal[1];
            final int count = curVal[2];

            if (curNode == dst) {
                result = Math.min(result, cost);
                continue;
            }

            for (final int[] nexts : graph.get(curNode)) {
                final int next = nexts[0];
                final int addCost = nexts[1];

                if (count > k) {
                    continue;
                }

                dq.addLast(new int[]{next, cost + addCost, count + 1});
            }
        }

        return result;
    }
}
