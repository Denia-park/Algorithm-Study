package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.countHomogenous("abbcccaa") == 13);
//        System.out.println(solution.countHomogenous("xy") == 2);
//        System.out.println(solution.countHomogenous("zzzzz") == 15);
        System.out.println(solution.countHomogenous("oooorppppppppooooobbbjjjjcccccccccccceeeee"));
    }
}

class Solution {
    int powVal = (int) (Math.pow(10, 9) + 7);

    public int countHomogenous(String quizStr) {
        Map<String, Integer> map = new HashMap<>();

        String saveStr = "";
        char saveChar = quizStr.charAt(0);
        for (int i = 0; i < quizStr.length(); i++) {
            final char curChar = quizStr.charAt(i);

            if (saveStr.isEmpty()) {
                saveStr = String.valueOf(saveChar);
            } else if (saveChar != curChar) {
                calculateCounting(saveStr, saveChar, map);

                saveChar = curChar;
                saveStr = String.valueOf(saveChar);
            } else {
                saveStr += curChar;
            }
        }

        calculateCounting(saveStr, saveChar, map);

        return map.values().stream().reduce(0, (integer, integer2) -> (integer % powVal + integer2 % powVal) % powVal);
    }

    private void calculateCounting(final String saveStr, final char saveChar, final Map<String, Integer> map) {
        final int saveStrLen = saveStr.length();
        for (int count = 0; count < saveStrLen; count++) {
            final String tempStr = String.valueOf(saveChar).repeat(count + 1);

            final Integer mapValue = map.getOrDefault(tempStr, 0);
            final int value = ((mapValue % powVal) + (saveStrLen % powVal) - (count % powVal)) % powVal;
            map.put(tempStr, value);
        }
    }
}
