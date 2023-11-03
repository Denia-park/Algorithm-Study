package CodingTest.LeetCode;

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
        if (num < 1 || num > 3999) return "";

        StringBuilder result = new StringBuilder();

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;

        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        
        return result.toString();
    }
}
