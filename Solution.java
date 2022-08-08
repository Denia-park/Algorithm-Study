package com.company;

public class Solution {
    static public void main(String[] args) {
        String str1 = "baabaa";
        String str2 = "cdcd";

        System.out.println(solution(str1));
        System.out.println(solution(str2));
    }

    static public int solution(String str)
    {
        while (true) {
            String afterStr = str;

            for (char c = 'a'; c <= 'z'; c++) {
                String tempStr = "" + c + c;
                str = str.replace(tempStr, "");
            }

            if(afterStr.equals(str)){
                return 0;
            }

            if(str.length() == 0) {
                return 1;
            }
        }
    }
}
