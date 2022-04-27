package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String testCaseNumStr = scanner.nextLine();
//        int testCaseNum = Integer.parseInt(testCaseNumStr);
//        String[] testCaseArray = new String[testCaseNum];
//
//        for (int i = 0; i < testCaseNum; i++) {
//            testCaseArray[i] = scanner.nextLine();
//        }

//        Scanner scanner = new Scanner(System.in);
//        int testValue = scanner.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testValue = Integer.parseInt(br.readLine());

        System.out.println(solveProblem(testValue));
        }
    //1 .. x   /   6  .. 2   /   11  .. 3
    //2 .. x   /   7  .. x   /   12  .. 4
    //3 .. 1   /   8  .. 2   /   13  .. 3
    //4 .. X   /   9  .. 3   /   14  .. 4
    //5 .. 1   /   10 .. 2   /   15  .. 3

    private static int solveProblem(int testValue) {
        int rtCount = 0;

        if (testValue < 11) {
            switch (testValue) {
                case 1:
                case 2:
                case 4:
                case 7:
                    return -1;
                case 3:
                case 5:
                    return 1;
                case 6:
                case 8:
                case 10:
                    return 2;
                case 9:
                    return 3;
            }
        } else {
            rtCount = testValue / 5;
            switch (testValue % 5) {
                case 0:
                    return rtCount;
                case 1:
                case 3:
                    return rtCount + 1;
                case 2:
                case 4:
                    return rtCount + 2;
            }
        }
        return rtCount;
    }
}
