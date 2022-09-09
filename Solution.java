package com.company;

// 참조 : https://school.programmers.co.kr/questions/10368
// 참조 : https://deveric.tistory.com/61

class Solution {
    //Combination nCr = n! / (r! * (n-r)!) 으로 처음에 풀었으나 overFlow 때문에 계산이 되지 않음
    //피보나치 수열로 접근을 해야한다.
    //DP 문제 , 메모이제이션 접근
    public int solution(int quizNum) {
        long[] memo = new long[quizNum + 1];

        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= quizNum; i++) {
            memo[i] = (memo[i-1] + memo[i-2])% 1000000007;
        }

        return (int) (memo[quizNum]);
    }
}
