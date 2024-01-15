package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")));
        System.out.println("2 : " + solution.findWinners(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[2,3],[1,3],[5,4],[6,4]]")));
    }
}

class Solution {
    public List<List<Integer>> findWinners(final int[][] matches) {
        final Set<Integer> winner = new HashSet<>();
        final Map<Integer, Integer> loser = new HashMap<>();

        for (final int[] match : matches) {
            final int winnerNum = match[0];
            final int loserNum = match[1];

            winner.add(winnerNum);
            loser.put(loserNum, loser.getOrDefault(loserNum, 0) + 1);
        }

        for (final Integer loserNum : loser.keySet()) {
            winner.remove(loserNum);
        }

        return List.of(
                winner.stream()
                        .sorted()
                        .collect(Collectors.toList()),
                loser.keySet().stream()
                        .filter(loserNum -> loser.get(loserNum) < 2)
                        .sorted()
                        .collect(Collectors.toList())
        );
    }
}
