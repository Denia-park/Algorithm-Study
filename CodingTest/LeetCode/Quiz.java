package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }
}

class Solution {
    public int[] findDiagonalOrder(final List<List<Integer>> nums) {
        final List<Integer> answer = new ArrayList<>();

        final int totalCount = nums.stream().mapToInt(List::size).sum();
        final int rowMax = nums.size() - 1;
        int addRow = 0;

        int row = 0;
        int col = 0;

        int rowCount = 0;

        while (answer.size() < totalCount) {
            try {
                final int value = nums.get(row).get(col);

                answer.add(value);
            } catch (final Exception ignored) {
            }

            if (row == 0) {
                if (rowCount < rowMax) {
                    rowCount++;
                }

                row = rowCount;
                col = addRow;
                continue;
            }

            if (row == rowMax) {
                addRow++;
            }

            row--;
            col++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
