package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.minWindow("ADOBECODEBANC", "ABC")));
        System.out.println((solution.minWindow("a", "a")));
        System.out.println((solution.minWindow("a", "aa")));
        System.out.println((solution.minWindow("ab", "a")));
        System.out.println((solution.minWindow("cabefgecdaecf", "cae")));
        System.out.println((solution.minWindow("cab", "ab")));
    }
}

class Solution {
    public String minWindow(final String str, final String t) {
        final int length = str.length();
        final Map<Character, Integer> targetMap = new HashMap<>();
        for (final char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        final int need = targetMap.size();
        int left = 0, right = 0;
        int count = 0;

        final Map<Character, Integer> windowCounts = new HashMap<>();
        final int[] ans = {Integer.MAX_VALUE, 0, 0};

        while (right < length) {
            final char rch = str.charAt(right);
            windowCounts.put(rch, windowCounts.getOrDefault(rch, 0) + 1);

            if (targetMap.containsKey(rch) && windowCounts.get(rch).equals(targetMap.get(rch))) {
                count++;
            }

            while (left <= right && count == need) {
                final int curWordLen = right - left + 1;
                if (curWordLen < ans[0]) {
                    ans[0] = curWordLen;
                    ans[1] = left;
                    ans[2] = right;
                }

                final char lch = str.charAt(left);
                windowCounts.put(lch, windowCounts.get(lch) - 1);

                if (targetMap.containsKey(lch) && windowCounts.get(lch) < targetMap.get(lch)) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == Integer.MAX_VALUE ? "" : str.substring(ans[1], ans[2] + 1);
    }
}
