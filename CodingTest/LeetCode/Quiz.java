package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solution.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(solution.lengthOfLongestSubstring("aab") == 2);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {
                left = charIndex[s.charAt(right)] + 1;
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
