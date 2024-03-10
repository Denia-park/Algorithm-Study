package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(final String[] commands) {
        final List<String> answer = new ArrayList<>();

        final String[] table = new String[51 * 51];
        final int[] parents = new int[51 * 51];
        for (int i = 0; i < 51 * 51; i++) {
            parents[i] = i;
        }

        for (final String command : commands) {
            final String[] split = command.split(" ");
            final int len = split.length;

            final String com = split[0];

            if (com.equals("UPDATE")) {
                //값 입력
                if (len == 4) {
                    final int row = Integer.parseInt(split[1]);
                    final int col = Integer.parseInt(split[2]);
                    final int parent = getParent(parents, convert(row, col));
                    table[parent] = split[3];
                }
                //값 변경
                else if (len == 3) {
                    final String value1 = split[1];
                    final String value2 = split[2];

                    for (int row = 0; row < 51; row++) {
                        for (int col = 0; col < 51; col++) {
                            final int parent = getParent(parents, convert(row, col));

                            if (table[parent] == null) {
                                continue;
                            }

                            if (table[parent].equals(value1)) {
                                table[parent] = value2;
                            }
                        }
                    }
                }
            } else if (com.equals("MERGE")) {
                final int row1 = Integer.parseInt(split[1]);
                final int col1 = Integer.parseInt(split[2]);
                final int convert1 = convert(row1, col1);
                final int row2 = Integer.parseInt(split[3]);
                final int col2 = Integer.parseInt(split[4]);
                final int convert2 = convert(row2, col2);

                if (convert1 == convert2) {
                    continue;
                }

                String saveVal = table[convert1];
                if (table[convert1] == null && table[convert2] != null) {
                    saveVal = table[convert2];
                }

                union(parents, convert1, convert2);
                final int parent = getParent(parents, convert1);
                table[parent] = saveVal;
            } else if (com.equals("UNMERGE")) {
                final int row = Integer.parseInt(split[1]);
                final int col = Integer.parseInt(split[2]);
                final int convert = convert(row, col);
                final int parent = getParent(parents, convert);
                final String saveVal = table[parent];

                for (int i = 0; i < 51 * 51; i++) {
                    if (parents[i] == parent) {
                        parents[i] = i;
                        table[i] = null;
                    }
                }

                table[convert] = saveVal;
            } else if (com.equals("PRINT")) {
                final int row = Integer.parseInt(split[1]);
                final int col = Integer.parseInt(split[2]);
                final int parent = getParent(parents, convert(row, col));
                final String val = table[parent];

                answer.add(val == null ? "EMPTY" : val);
            }
        }

        return answer.toArray(String[]::new);
    }

    private void union(final int[] parents, final int convert1, final int convert2) {
        final int parent1 = getParent(parents, convert1);
        final int parent2 = getParent(parents, convert2);

        parents[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
    }

    private int getParent(final int[] parents, final int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        parents[idx] = getParent(parents, parents[idx]);

        return parents[idx];
    }

    private int convert(final int row, final int col) {
        return 50 * row + col;
    }
}
