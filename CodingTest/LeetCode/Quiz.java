package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code") == 2);
        System.out.println(solution.rearrangeCharacters("abcba", "abc") == 1);
        System.out.println(solution.rearrangeCharacters("abbaccaddaeea", "aaaaa") == 1);
    }
}

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int answer = Integer.MAX_VALUE;

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            final Character targetKey = entry.getKey();
            final Integer targetVal = entry.getValue();

            final Integer sVal = sMap.getOrDefault(targetKey, 0);

            if (sVal == 0) {
                return 0;
            } else {
                answer = Math.min(answer, sVal / targetVal);
            }
        }

        return answer;
    }
}
