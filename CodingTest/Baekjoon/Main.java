package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String nums = br.readLine();
        int quizCount = Integer.parseInt(br.readLine());
        String[] quizs = new String[quizCount];
        for (int i = 0; i < quizCount; i++) {
            quizs[i] = br.readLine();
        }

        sol.solution(nums, quizs);
    }
}

class BjSolution {

    private int[] arr;

    public void solution(String nums, String[] quizs) {
        String[] tempNumsArr = nums.split(" ");
        int[] numsArr = new int[tempNumsArr.length];

        int idx = 0;
        for (String s : tempNumsArr) {
            numsArr[idx++] = Integer.parseInt(s);
        }
        arr = numsArr;

        for (String quiz : quizs) {
            System.out.println(isPalindrome(quiz));
        }
    }

    private int isPalindrome(String quiz) {
        String[] quizConditions = quiz.split(" ");
        int start = Integer.parseInt(quizConditions[0]) - 1;
        int end = Integer.parseInt(quizConditions[1]) - 1;

        int count = end - start + 1;
        int limit;

        //odd
        if (count % 2 == 1) {
            limit = count / 2;
        }
        //even
        else {
            limit = count / 2 + 1;
        }
        for (int i = 0; i < limit; i++) {
            if (arr[start + i] != arr[end - i]) {
                return 0;
            }
        }

        return 1;
    }
}

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
