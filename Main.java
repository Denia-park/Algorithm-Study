package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int treeNum = Integer.parseInt(st.nextToken());
        int needLength = Integer.parseInt(st.nextToken());

        int[] trees = new int[treeNum];

        st = new StringTokenizer(br.readLine());

        int curMaxTreeHeight = 0;
        int curCutterHeight = 0;
        int curTotalLenghth = 0;
        int curMinusValue = 1;

        for(int i = 0; i<trees.length; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(curMaxTreeHeight < trees[i])
                curMaxTreeHeight = trees[i];
        }

        while(curTotalLenghth != needLength){
            curTotalLenghth = 0;
            curCutterHeight = curMaxTreeHeight - curMinusValue;
            curMinusValue++;

            for (int i = 0; i < treeNum; i++) {
                if(trees[i] > curCutterHeight)
                    curTotalLenghth += trees[i] - curCutterHeight;
            }

        }

        System.out.println(curCutterHeight);
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

