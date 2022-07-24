package com.company;

class Solution {
    static public void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
    }

    static public int solution(int n) {
        int answer = 0;

        for(int i = 1 ; i< n ;i++){
            if(n % i == 1){
                answer = i;
                break;
            }
        }

        return answer;
    }
}

