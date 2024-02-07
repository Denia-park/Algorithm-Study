package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }
}

class Solution {
    public String frequencySort(final String s) {
        final Map<Character, MyCh> map = new HashMap<>();

        final char[] chars = s.toCharArray();

        for (final char ch : chars) {
            map.computeIfAbsent(ch, key -> new MyCh(key, 0)).up();
        }

        final List<MyCh> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt((MyCh myCh) -> myCh.count).reversed());

        final StringBuilder sb = new StringBuilder();
        for (final MyCh myCh : list) {
            for (int i = 0; i < myCh.count; i++) {
                sb.append(myCh.ch);
            }
        }

        return sb.toString();
    }

    static class MyCh {
        char ch;
        int count;

        public MyCh(final char ch, final int count) {
            this.ch = ch;
            this.count = count;
        }

        public void up() {
            count++;
        }
    }
}
