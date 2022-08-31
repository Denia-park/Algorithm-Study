package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numArr = number.toCharArray();
        char[] tempNumArr = number.toCharArray();
        int numberLength = tempNumArr.length;
        Arrays.sort(tempNumArr);

        List<Character> smallValueList = new ArrayList<>();
        char[] smallValueArr = new char[k];

        System.arraycopy(tempNumArr, 0, smallValueArr, 0, k);

        StringBuilder sb = new StringBuilder();
        a : for (int i = 0; i < numberLength; i++) {
            for (int j = 0; j < k; j++) {
                if (numArr[i] == smallValueArr[j]) {
                    smallValueArr[j] = '\0';
                    continue a;
                }
            }
            sb.append(numArr[i]);
        }



        return sb.toString();
    }
}
