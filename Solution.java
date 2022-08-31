package com.company;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = startIndex; j <= i + k ; j++) {
                int tempChar = number.charAt(j) - '0';
                if(tempChar > maxValue){
                    maxValue = tempChar;
                    startIndex = j + 1;
                }
            }

            sb.append(maxValue);
        }

        return sb.toString();
    }
}
