package com.company;

import java.util.Stack;

public class Solution {
    static public void main(String[] args) {

        System.out.println(solution(3,5));
        System.out.println(solution(8,12));
    }

    // 해당 문제의 자세한 풀이는 다음 사이트 내용을 참조함 [https://school.programmers.co.kr/questions/11306]

    //우선 w와 h가 공약수가 있다면 문제를 공약수를 나눈 w' 와 h'로 축소시킬수있습니다.
    //w'와 h'가 서로소라 가정했을때 대각선은 반대쪽 코너에 도달하기전 w'-1 세로선과 h'-1 가로선을 지나고
    //지날때마다 새로운 정사각형이 추가됩니다.
    // 그래서 첫 정사각형을 포함 1 + (w'-1) + (h'-1) = w' + h' - 1개의 정사각형을 지나게 되므로
    // 공약수를 다시 곱해주면 w + h - gcd(w,h)개의 정사각형을 지나는것을 찾을수있습니다.

    //gcd 메서드는 최대 공약수를 구하는 메서드 이며 유클리드 호제법을 사용함
    static public long solution(int w, int h) {
        long answer = 0;

        long totalRect = (long) w * h;

        answer = totalRect - (w + h - gcd(w, h));

        return answer;
    }

    //유클리드 호제법 을 사용하여 최대공약수를 구함
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
