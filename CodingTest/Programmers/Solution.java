package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int TOTAL_SIZE = 51 * 51;

    public String[] solution(final String[] commands) {
        final List<String> answer = new ArrayList<>();

        final String[] table = new String[TOTAL_SIZE];
        final int[] parents = new int[TOTAL_SIZE];
        for (int i = 0; i < TOTAL_SIZE; i++) {
            parents[i] = i;
        }

        for (final String command : commands) {
            final String[] split = command.split(" ");
            final int len = split.length;

            final String com = split[0];

            if (com.equals("UPDATE") && len == 4) {
                //값 입력
                final int parent = getParentByRowCol(parents, split[1], split[2]);
                table[parent] = split[3];
            } else if (com.equals("UPDATE") && len == 3) {
                //값 수정

                for (int idx = 0; idx < TOTAL_SIZE; idx++) {
                    if (table[idx] != null && table[idx].equals(split[1])) {
                        table[idx] = split[2];
                    }
                }
            } else if (com.equals("MERGE")) {
                final int row1 = Integer.parseInt(split[1]);
                final int col1 = Integer.parseInt(split[2]);
                final int convert1 = getIdxByRowCol(row1, col1);
                final int row2 = Integer.parseInt(split[3]);
                final int col2 = Integer.parseInt(split[4]);
                final int convert2 = getIdxByRowCol(row2, col2);

                if (convert1 == convert2) {
                    continue;
                }

                final int parent1 = getParent(parents, convert1);
                final int parent2 = getParent(parents, convert2);

                String saveVal = table[parent1];
                if (table[parent1] == null && table[parent2] != null) {
                    saveVal = table[parent2];
                }

                final int unionParent = union(parents, convert1, convert2);
                table[unionParent] = saveVal;
            } else if (com.equals("UNMERGE")) {
                final int row = Integer.parseInt(split[1]);
                final int col = Integer.parseInt(split[2]);
                final int convert = getIdxByRowCol(row, col);
                final int parent = getParent(parents, convert);
                final String saveVal = table[parent];

                for (int i = 0; i < TOTAL_SIZE; i++) {
                    getParent(parents, i);
                }

                for (int i = 0; i < TOTAL_SIZE; i++) {
                    if (parents[i] == parent) {
                        parents[i] = i;
                        table[i] = null;
                    }
                }

                table[convert] = saveVal;
            } else if (com.equals("PRINT")) {
                final int row = Integer.parseInt(split[1]);
                final int col = Integer.parseInt(split[2]);
                final int parent = getParent(parents, getIdxByRowCol(row, col));
                final String val = table[parent];

                answer.add(val == null ? "EMPTY" : val);
            }
        }

        return answer.toArray(String[]::new);
    }

    private int union(final int[] parents, final int convert1, final int convert2) {
        final int parent1 = getParent(parents, convert1);
        final int parent2 = getParent(parents, convert2);

        final int min = Math.min(parent1, parent2);
        parents[Math.max(parent1, parent2)] = min;

        return min;
    }


    private int getParentByRowCol(final int[] parents, final String rowStr, final String colStr) {
        final int row = Integer.parseInt(rowStr);
        final int col = Integer.parseInt(colStr);

        return getParent(parents, getIdxByRowCol(row, col));
    }

    private int getIdxByRowCol(final int row, final int col) {
        return 50 * row + col;
    }

    private int getParent(final int[] parents, final int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        parents[idx] = getParent(parents, parents[idx]);

        return parents[idx];
    }
}
