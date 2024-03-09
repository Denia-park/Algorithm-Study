package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(final int[] rank, final boolean[] attendance) {
        final int rankLen = rank.length;

        final List<Student> list = new ArrayList<>();

        for (int i = 0; i < rankLen; i++) {
            list.add(new Student(i, rank[i], attendance[i]));
        }

        final List<Student> collect = list.stream()
                .filter(s -> s.isAble)
                .sorted(Comparator.comparingInt(s -> s.rank))
                .collect(Collectors.toList());

        final int a = collect.get(0).idx;
        final int b = collect.get(1).idx;
        final int c = collect.get(2).idx;

        return 10000 * a + 100 * b + c;
    }

    class Student {
        int idx;
        int rank;
        boolean isAble;

        Student(final int idx, final int rank, final boolean isAble) {
            this.idx = idx;
            this.rank = rank;
            this.isAble = isAble;
        }
    }
}
