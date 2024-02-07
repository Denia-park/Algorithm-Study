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
        for (final char ch : s.toCharArray()) {
            map.computeIfAbsent(ch, MyCh::new).up();
        }

        final List<MyCh> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(MyCh::getCount).reversed());

        final StringBuilder sb = new StringBuilder();
        for (final MyCh myCh : list) {
            sb.append(String.valueOf(myCh.ch).repeat(myCh.count));
        }

        return sb.toString();
    }

    static class MyCh {
        char ch;
        int count;

        public MyCh(final char ch) {
            this.ch = ch;
            this.count = 0;
        }

        public void up() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
