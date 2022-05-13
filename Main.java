package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //사람의 수
        int testCase = Integer.parseInt(br.readLine());
        int[] inputArray = new int[testCase];

        //각 사람이 돈을 인출하는데 걸리는 시간
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        solveProblem(inputArray);
    }

    static private void solveProblem(int[] inputArray) {
        int rtVal = 0;
        int arrSize = inputArray.length;
        //inpuntArray = [3 1 4 3 2]

        //최소 시간을 구하려면 제일 짧게 걸리는 값들을 앞에 배치해야함 = 정렬이 필요
        Arrays.sort(inputArray);

        //inpuntArray = [1 2 3 3 4]

        // 앞에 있는 사람의 시간은 중복되서 뒷 사람의 시간에 더해지므로
        // 자기 포함 뒤에 기다리는 사람 수 만큼 곱하고 나온 값들 계속해서 다 더하면 최소 시간의 합이다.

        //1
        //1 2
        //1 2 3
        //1 2 3 3
        //1 2 3 3 4

        // (해당 걸리는 시간 * (뒤에 기다리는 사람 수 + 1) ) 의 총합
        // (1 * 5) + (2 * 4) + (3 * 3) + (3 * 2) + (4 * 1)

        for (int j : inputArray) {
            rtVal += arrSize * j;
            arrSize--;
        }

        System.out.println(rtVal);
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

