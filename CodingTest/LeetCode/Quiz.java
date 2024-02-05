package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.firstUniqChar("leetcode")));
        System.out.println((solution.firstUniqChar("loveleetcode")));
        System.out.println((solution.firstUniqChar("aabb")));
    }
}

class Solution {
    public int firstUniqChar(final String s) {
        final char[] chars = s.toCharArray();

        final Map<Character, MyChar> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            final char ch = chars[i];

            final MyChar myChar = map.getOrDefault(ch, new MyChar(i));
            myChar.count();
            map.put(ch, myChar);
        }

        final List<Map.Entry<Character, MyChar>> list = map.entrySet().stream()
                .filter(entry -> entry.getValue().count < 2)
                .sorted(Comparator.comparingInt(value -> value.getValue().idx))
                .collect(Collectors.toList());

        return list.isEmpty() ? -1 : list.get(0).getValue().idx;
    }

    static class MyChar {
        int idx;
        int count;

        public MyChar(final int idx) {
            this.idx = idx;
            this.count = 0;
        }

        void count() {
            count++;
        }
    }
}
