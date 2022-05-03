package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        String[] testCase = new String[testCaseNum];
        for (int i = 0; i < testCaseNum; i++) {
            testCase[i] = br.readLine();
        }

        //저장한 데이터를 for문으로 확인해보자.
        for (int i = 0; i < testCaseNum; i++) {
            solveProblem(testCase[i]);
        }
    }

    static private void solveProblem(String inputString) {
        //Stack 생성
        Stack<Character> stack = new Stack<>();

        //String을 비교하기 좋게 CharArray로 변경
        char[] inputChars = inputString.toCharArray();

        //처음부터 ) 이 들어오면 잘못된 문자열 => "NO"
        if(inputChars[0] == ')'){
            System.out.println("NO");
            return;
        }

        //CharArray를 for문으로 비교하자
        for(int i = 0; i < inputChars.length; i++) {
            // ( 이 들어오면 무조건 push
            if(inputChars[i] == '('){
                stack.push(inputChars[i]);
            }
            // ) 이 들어오면 무조건 pop한다. empty 라면 잘못된 문자열 => "NO"
            else{
                if(stack.empty()){
                    System.out.println("NO");
                    return;
                }
                else{
                    stack.pop();
                }
            }
        }

        //문자열을 한바퀴 돌렸는데 남는게 없으면 정상 , 남아있으면 잘못된 문자열 => "NO"
        if(stack.empty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
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
//        int fiNum = Integer.parseInt(br.readLine());

