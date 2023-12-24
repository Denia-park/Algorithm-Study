package CodingTest.Programmers;

class Solution {
    String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for (int i = 0; i < nums.length; i++) {
            s = s.replace(nums[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
