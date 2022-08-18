package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 병사 배치하기

// 이 문제의 기본 아이디어는 가장 긴 증가하는 부분 수열 (LIS)로 알려진 전형적인 다이나믹 프로그래밍 문제의 아이디어
// 예를들어 하나의 수열 array = {4,2,5,8,4,11,15} 가 있다고 한다
    //이 수열의 가장 긴 증가하는 부분 수열은 {4,5,8,11,15} 이다
// 본 문제는 가장 긴 감소하는 부분 수열을 찾는 문제로 치환 , LIS 알고리즘을 조금 수정하여 적용함으로써 정답을 도출

// 가장 긴 증가하는 부분 수열 (LIS) 알고리즘을 확인
// D[i] = array[i]를 마지막 원소로 가지는 부분 수열의 최대 길이
// 점화식
    //모든 0<= j < i 에 대하여 , D[i] = max(D[i],D[j] + 1) if array[j] < array[i]

public class DP5 {

    static int n;
    static ArrayList<Integer> v = new ArrayList<Integer>();
    static int[] dp = new int[2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }

        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(v);

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
