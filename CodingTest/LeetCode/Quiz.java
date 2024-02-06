package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        )));
        System.out.println((solution.groupAnagrams(
                new String[]{""}
        )));
        System.out.println((solution.groupAnagrams(
                new String[]{"a"}
        )));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();

        for (final String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);

            final String temp = new String(chars);

            final List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(str);
            map.put(temp, list);
        }

        return new ArrayList<>(map.values());
    }
}
