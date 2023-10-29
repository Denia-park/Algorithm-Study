package CodingTest.LeetCode;

import java.util.HashSet;
import java.util.Set;

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
        Set<Character> set = new HashSet<>();
        final char[] charArray = s.toCharArray();
        int left = 0;
        int maxSize = 0;

        for (int right = 0; right < charArray.length; right++) {
            char ch = charArray[right];

            //set에 있는지 확인
            if (set.contains(ch)) {
                //set에 존재하면, 없어질때까지 left를 땡긴다.
                while (set.contains(ch)) {
                    set.remove(charArray[left]);
                    left++;
                }
            }

            //  set에 추가한다.
            set.add(ch);

            //  Max값을 갱신한다.
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }
}
