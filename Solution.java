package com.company;

import java.util.Arrays;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numberArr = number.toCharArray();
        int numberLength = numberArr.length;
        Arrays.sort(numberArr);
        for (int i = numberLength - 1; i >= numberLength - k; i--) {
            answer += numberArr[i];
        }
        return answer;
    }
}
