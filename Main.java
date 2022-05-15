package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int coinNum = 0;
        int targetPrice = 0;
        int count = 0;
        while (st.hasMoreTokens()) {
            if(count++ == 0)
                coinNum = Integer.parseInt(st.nextToken());
            else
                targetPrice = Integer.parseInt(st.nextToken());
        }

        int[] coinArray = new int[coinNum];

        for (int i = 0; i < coinNum; i++) {
            coinArray[i] = Integer.parseInt(br.readLine());
        }

        solveProblem(targetPrice,coinArray);
    }

    static private void solveProblem(int targetPrice ,int[] coinArray) {
        int rtCount = 0;
        int temp = targetPrice;
        for (int i = coinArray.length - 1; i >= 0; i--) {
            if(targetPrice == 0)
                break;

            if(targetPrice >= coinArray[i]){
                targetPrice = temp % coinArray[i];
                rtCount += temp / coinArray[i];
                temp = targetPrice;
            }
        }

        System.out.println(rtCount);
    }
}
//안쓰는 코드 모음

//        *Sacnner*
//        Scanner scanner = new Scanner(System.in);
//        String testCaseNumStr = scanner.nextLine();
//        int testCaseNum = Integer.parseInt(testCaseNumStr);
//        String[] testCaseArray = new String[testCaseNum];
//
//        for (int i = 0; i < testCaseNum; i++) {
//            testCaseArray[i] = scanner.nextLine();
//        }

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }

//    // N의 진짜 약수의 개수
//    int testCase = Integer.parseInt(br.readLine());
//    int[] inputArray = new int[testCase];
//
//    // N의 진짜 약수
//    StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//                for (int i = 0; i < testCase; i++) {
//        inputArray[i] = Integer.parseInt(st.nextToken());
//        }

