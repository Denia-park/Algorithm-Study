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
        String calculation = br.readLine();

        solveProblem(calculation);
    }

    static private void solveProblem(String intputString) {
        char[] chars = intputString.toCharArray();
        int[] numArr = new int[50];
        int numIndex = 0;
        int numArrIndex = 0;
        int symbol = 1; // plus 1 , minus -1

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '+' || chars[i] == '-'){
                String temp = intputString.substring(numIndex, i);
                numArr[numArrIndex++] = symbol * Integer.parseInt(temp);
                numIndex = i + 1;
                if(chars[i] == '-')
                    symbol = -1;
            }
        }
        String temp = intputString.substring(numIndex, chars.length);
        numArr[numArrIndex++] = symbol * Integer.parseInt(temp);

        int totalSum = 0;
        for (int i = 0; i < 50 ; i ++){
            totalSum += (numArr[i]);
        }

        System.out.println(totalSum);
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

