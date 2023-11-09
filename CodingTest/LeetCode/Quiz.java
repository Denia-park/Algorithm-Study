package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countHomogenous("abbcccaa") == 13);
        System.out.println(solution.countHomogenous("xy") == 2);
        System.out.println(solution.countHomogenous("zzzzz") == 15);
    }
}

class Solution {
    public int countHomogenous(String quizStr) {
        Map<String, Integer> map = new HashMap<>();

        String saveStr = "";
        char saveChar = quizStr.charAt(0);
        for (int i = 0; i < quizStr.length(); i++) {
            final char curChar = quizStr.charAt(i);

            if (saveStr.isEmpty()) {
                saveStr = String.valueOf(saveChar);
            } else if (saveChar != curChar) {
                final int saveStrLen = saveStr.length();
                for (int count = 0; count < saveStrLen; count++) {
                    final String tempStr = String.valueOf(saveChar).repeat(count + 1);
                    map.put(tempStr, map.getOrDefault(saveStr, 0) + saveStrLen - count);
                }

                saveChar = curChar;
                saveStr = String.valueOf(saveChar);
            } else {
                saveStr += curChar;
            }
        }

        final int saveStrLen = saveStr.length();
        for (int count = 0; count < saveStrLen; count++) {
            final String tempStr = String.valueOf(saveChar).repeat(count + 1);
            map.put(tempStr, map.getOrDefault(tempStr, 0) + saveStrLen - count);
        }

        return map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
