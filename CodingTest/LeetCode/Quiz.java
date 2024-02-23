package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.*;

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
    public int findCheapestPrice(final int n, final int[][] flights, final int src, final int dst, final int k) {
        final Map<Integer, List<int[]>> adj = new HashMap<>();
        for (final int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        final int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{src, 0});
        int stops = 0;

        while (!dq.isEmpty() && stops <= k) {
            int size = dq.size();
            while (size-- > 0) {
                final int[] curr = dq.poll();
                final int curNode = curr[0];
                final int curPrice = curr[1];

                if (!adj.containsKey(curNode)) continue;

                for (final int[] next : adj.get(curNode)) {
                    final int nextNode = next[0];
                    final int nextPrice = next[1];

                    if (curPrice + nextPrice >= dist[nextNode]) continue;
                    dist[nextNode] = curPrice + nextPrice;

                    dq.offerLast(new int[]{nextNode, dist[nextNode]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
