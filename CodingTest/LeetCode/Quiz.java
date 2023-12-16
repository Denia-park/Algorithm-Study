package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}

class Solution {
    public boolean isAnagram(final String s, final String t) {

        final Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        final Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            final char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
