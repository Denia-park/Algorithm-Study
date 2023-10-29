package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solution.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solution.lengthOfLongestSubstring("pwwkew") == 3);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final char[] charArray = s.toCharArray();

        int maxSize = 0;
        int curSize = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            //map에 있는지 확인
            if (map.containsKey(ch)) {
                map.clear();
                curSize = 0;
                continue;
            }

            //없으면 길이 추가
            map.put(ch, 1);
            curSize++;
            maxSize = Math.max(maxSize, curSize);
        }


        return maxSize;
    }
}
