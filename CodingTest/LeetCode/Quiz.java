package CodingTest.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        final int[] diagonalOrder = solution.findDiagonalOrder(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9))
        );

        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));

        final int[] diagonalOrder1 = solution.findDiagonalOrder(List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7),
                List.of(8),
                List.of(9, 10, 11),
                List.of(12, 13, 14, 15, 16))
        );

        System.out.println("diagonalOrder1 = " + Arrays.toString(diagonalOrder1));

        final int[] diagonalOrder2 = solution.findDiagonalOrder(List.of(
                List.of(1, 2, 3, 4, 5, 6))
        );

        System.out.println("diagonalOrder2 = " + Arrays.toString(diagonalOrder2));

        final int[] diagonalOrder3 = solution.findDiagonalOrder(List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7))
        );

        System.out.println("diagonalOrder2 = " + Arrays.toString(diagonalOrder3));

    }
}

class Solution {
    public int[] findDiagonalOrder(final List<List<Integer>> nums) {
        final int totalCount = nums.stream().mapToInt(List::size).sum();
        final int[] answer = new int[totalCount];

        final Map<Integer, Deque<Integer>> map = new HashMap<>();

        for (int row = 0; row < nums.size(); row++) {
            final List<Integer> rows = nums.get(row);

            for (int col = 0; col < nums.get(row).size(); col++) {
                final int key = row + col;

                Deque<Integer> deque = map.get(key);

                if (map.get(key) == null) {
                    deque = new ArrayDeque<>();

                    map.put(key, deque);
                }

                deque.push(rows.get(col));

                map.put(key, deque);
            }
        }

        int idx = 0;

        final List<Integer> keys = map.keySet().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (final Integer key : keys) {
            final Deque<Integer> integers = map.get(key);

            while (!integers.isEmpty()) {
                answer[idx++] = integers.pop();
            }
        }

        return answer;
    }
}
