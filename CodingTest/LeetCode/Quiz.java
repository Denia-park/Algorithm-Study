package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.intToRoman(3).equals("III"));
//        System.out.println(solution.intToRoman(58).equals("LVIII"));
        System.out.println(solution.intToRoman(58));
//        System.out.println(solution.intToRoman(1994).equals("MCMXCIV"));
        System.out.println(solution.intToRoman(1994));
    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        addRomanData(map);

        //숫자 하나씩 가져오고, num의 자리수를 파악
        String numStr = String.valueOf(num);
        int digit = 1;
        for (int idx = numStr.length() - 1; idx >= 0; idx--) {
            char ch = numStr.charAt(idx);

            int numValue = ch - '0';

            StringBuilder tempBuilder = new StringBuilder();

            if (numValue != 0) {
                if (1 < numValue && numValue < 4) { //2, 3
                    for (int i = 0; i < numValue; i++) {
                        tempBuilder.insert(0, map.get(1 * digit));
                    }
                } else if (5 < numValue && numValue < 9) { //6, 7, 8
                    int numMinus5 = numValue - 5;
                    for (int i = 0; i < numMinus5; i++) {
                        tempBuilder.insert(0, map.get(1 * digit));
                    }
                    tempBuilder.insert(0, map.get(5 * digit));
                } else {
                    tempBuilder.insert(0, map.get(numValue * digit));
                }

                sb.insert(0, tempBuilder);
            }

            digit *= 10;
        }

        //해당 하는 값을 붙인다
        return sb.toString();
    }

    private void addRomanData(final Map<Integer, String> map) {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");

        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");

        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");

        map.put(1000, "M");
    }
}
