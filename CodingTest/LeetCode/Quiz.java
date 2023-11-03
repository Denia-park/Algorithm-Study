package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.intToRoman(3).equals("III"));
        System.out.println(solution.intToRoman(58).equals("LVIII"));
        System.out.println(solution.intToRoman(1994).equals("MCMXCIV"));
    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        addRomanData(map);

        for (final Map.Entry<Integer, String> entry : map.entrySet()) {
            final Integer numToMinus = entry.getKey();
            final String roman = entry.getValue();
            while (num >= numToMinus) {
                sb.append(roman);
                num -= numToMinus;
            }
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
