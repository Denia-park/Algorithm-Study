package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final boolean IS_NOT_PRIME = true;
    static final boolean IS_PRIME = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int stNum = Integer.parseInt(st.nextToken());
        int fiNum = Integer.parseInt(st.nextToken());

        //에라스토테네스의 체 방식을 사용하자. (https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4)
        int MAX_NUM_LIMIT = 1000_000;
        boolean[] eratosArray = new boolean[MAX_NUM_LIMIT+1]; //배열 과 사용할 Index를 맞추기 위해서 +1 해줌 , default는 모두 IS_PRIME이다.

        eratosArray[0] = IS_NOT_PRIME; // 0 소수 아님
        eratosArray[1] = IS_NOT_PRIME; // 1 소수 아님

        //소수값을 미리 배열에 정의
        for (int i = 2; i <= fiNum ; i++) {
            if(eratosArray[i] == IS_NOT_PRIME)
                continue;
            
            for (int j = 2; i*j <= fiNum; j++) {
                eratosArray[i * j] = IS_NOT_PRIME;
            }
        }

        for (int i = stNum; i <= fiNum; i++) {
            if(eratosArray[i] == IS_PRIME)
            {
                System.out.println(i);
            }
        }
    }
}


//안쓰는 코드 모음

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

//        int testValue = Integer.parseInt(br.readLine());


//    private static void solveProblem(int testValue) {
//        if((testValue) == 0){
//            System.out.println(testValue);
//        }
//    }
