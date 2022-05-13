package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N의 진짜 약수의 개수
        int testCase = Integer.parseInt(br.readLine());
        int[] inputArray = new int[testCase];

        // N의 진짜 약수
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        solveProblem(inputArray);
    }

    static private void solveProblem(int[] inputArray) {
        int arrSize = inputArray.length;
        //arrSzie == 1
        //제곱값 이므로 그냥 제곱 하고 끝

        //arrSize != 1
        //약수들을 정렬하고 약수중에 제일 작은 값 * 제일 큰 값을 하면 어떤 수 N이 나옴
        //12의 약수 => [1, 2, 3, 4, 6, 12]
        Arrays.sort(inputArray);

        System.out.println(inputArray[0] * inputArray[arrSize - 1]);
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

