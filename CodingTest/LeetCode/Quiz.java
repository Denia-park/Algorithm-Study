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
        int answer = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            tMap.put(target.charAt(i), tMap.getOrDefault(target.charAt(i), 0) + 1);
        }

        while (true) {
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                //tMap의 값이 다 있어야 개수를 셀수있다.
                final Character key = entry.getKey();
                final Integer tValue = entry.getValue();

                if (sMap.containsKey(key)) {
                    final Integer sValue = sMap.get(key);

                    if (sValue >= tValue) {
                        sMap.put(key, sValue - tValue);
                    } else {
                        return answer;
                    }
                } else {
                    return answer;
                }
            }

            answer++;
        }
    }
}
