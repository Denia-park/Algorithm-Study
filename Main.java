package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testCaseNumStr = scanner.nextLine();
        int testCaseNum = Integer.parseInt(testCaseNumStr);
        String[] testCaseArray = new String[testCaseNum];

        for (int i = 0; i < testCaseNum; i++) {
            testCaseArray[i] = scanner.nextLine();
        }

        for (int i = 0; i <testCaseNum; i++) {
        String[] inputValues = testCaseArray[i].split(" ");
        int startNum = Integer.parseInt(inputValues[0]);
        int finishNum = Integer.parseInt(inputValues[1]);

        System.out.println(solveProblem(finishNum-startNum));
        }
    }

    //처음부터 모든 케이스
    //Num : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
    //Cnt : 1 2 3 3 4 4 5 5 5 6  6  6  7  7  7  7  8

    //제곱근이 정수인 경우 (제곱근은 maxValue)
    // Num : 1  4  9  16
    // Cnt : 1  3  5  7  (홀수로 커진다)
    // => rtCount = 2 * maxValue - 1;

    //제곱근이 정수인 값들의 사이값은 짝수개로 존재하며, 짝수개의 절반이 지나면 Cnt 가 1 증가한다.
    // 예를 들어 4 5 6 7 8 9 가 있을때 4 와 9 사이를 보면
    // 5 6 7 8 이 존재하며 5 6 의 개수가 같고 7 8의 개수가 같다.
    // 5 6 은 4개 , 7 8 은 5개

    // 4 에서 4의 제곱근을 더한 값 (6) 까지는 제곱근이 정수인 경우의 rtCount 보다  1 이 크다
    // =>  rtCount = 2 * maxValue ;

    // 그 외의 값들은 제곱근이 정수인 경우의 rtCount 보다  2 가 크다
    // =>  rtCount = 2 * maxValue + 1 ;

    private static int solveProblem(int diffNum){
        int rtCount = 0;

        int maxValue = (int) Math.sqrt(diffNum);

            if( Math.pow(maxValue,2) == diffNum){ // 제곱근이 정수인 경우 1,4,9,16
                rtCount = 2 * maxValue - 1;
            } else if(Math.pow(maxValue,2) + maxValue < diffNum ){
                rtCount = 2 * maxValue + 1;
            } else {
                rtCount = 2 * maxValue;
            }

        return rtCount;
    }

}
