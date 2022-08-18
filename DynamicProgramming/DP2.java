package com.company.DynamicProgramming;

import java.util.Scanner;

// 1로 만들기
// 피보나치 수열 문제를 도식화한 것처럼 함수가 호출되는 과정을 그림으로 그려보면 다음과 같다.
    //최적 부분 구조 와 중복되는 부분 문제를 만족
// 해당 문제는 단순한 그리디 알고리즘을 사용해서는 풀기가 어렵다
public class DP2 {
    public static int[] d = new int[30001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N을 입력받기
//        int n = sc.nextInt();

        int n = 26;

        d[0] = Integer.MAX_VALUE;
        d[1] = 0;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 1;

        for (int i = 6; i < n + 1; i++) {
            int[] tempValArr = new int[4];

            if(i % 5 == 0)  tempValArr[0] = i / 5;
            if(i % 3 == 0)  tempValArr[1] = i / 3;
            if(i % 2 == 0)  tempValArr[2] = i / 2;
            if(i - 1 > 1)   tempValArr[3] = i - 1;

            int tempCount = Math.min(Math.min(d[tempValArr[0]], d[tempValArr[1]]), Math.min(d[tempValArr[2]], d[tempValArr[3]]));

            d[i] = tempCount + 1;
        }

        System.out.println(d[n]);
    }
}

// 나동빈님 코드

//import java.util.*;
//
//public class Main {
//
//    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
//    public static int[] d = new int[30001];
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int x = sc.nextInt();
//
//        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
//        for (int i = 2; i <= x; i++) {
//            // 현재의 수에서 1을 빼는 경우
//            d[i] = d[i - 1] + 1;
//            // 현재의 수가 2로 나누어 떨어지는 경우
//            if (i % 2 == 0)
//                d[i] = Math.min(d[i], d[i / 2] + 1);
//            // 현재의 수가 3으로 나누어 떨어지는 경우
//            if (i % 3 == 0)
//                d[i] = Math.min(d[i], d[i / 3] + 1);
//            // 현재의 수가 5로 나누어 떨어지는 경우
//            if (i % 5 == 0)
//                d[i] = Math.min(d[i], d[i / 5] + 1);
//        }
//
//        System.out.println(d[x]);
//    }
//}
