package com.company;

public class Solution {

    public int solution(int n) {
        int[] memo = new int[n/2 + 1];
        if(n == 1 || n == 2 || n == 3) {
            return 1;
        }

        memo[1] = 1;
        memo[2] = 1;

        for(int i = 3; i <= n/2; i++) {
            memo[i] = i % 2 == 0 ? memo[i / 2] : memo[i / 2] + 1;
        }

        return n % 2 == 0 ? memo[n / 2] : memo[n / 2] + 1;
    }
}
