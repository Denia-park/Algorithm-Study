package com.company;

import java.util.Stack;

public class Solution {
    static public void main(String[] args) {
        String str1 = "baabaa";
        String str2 = "cdcd";

        System.out.println(solution(str1));
        System.out.println(solution(str2));
    }

    static public int solution(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            if(!stack.isEmpty() && stack.peek().equals(tempChar)){
                stack.pop();
            }else{
                stack.push(tempChar);
            }
        }

        if(stack.isEmpty()) return 1;

        return 0;
    }
}
