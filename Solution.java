package com.company;

class Solution {
    //Combination nCr = n! / (r! * (n-r)!)
    public int solution(int quizNum) {
        // 기본 값을 1 (모두 1칸으로 채웠을 경우)
        long answer = 1;

        //
        int n = quizNum - 1;
        int r = 1;

        while (2 * r <= quizNum){
            answer += combination(n,r);
            n--;
            r++;
        }

        return (int) (answer % 1000000007);
    }

    private long combination(int n , int r) {
        long numerator = 1;
        //numerator
        for (long i = n; i > n-r; i--) {
            numerator *= i;
        }

        long denominator = 1;
        //denominator
        for (long i = 1; i <= r; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }

}
