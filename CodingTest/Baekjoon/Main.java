package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] quizArr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            quizArr[i] = Integer.parseInt(br.readLine());
        }
        sol.solution(testCase, quizArr);
    }
}

class BjSolution {
    public void solution(int testCase, int[] quizArr) {
        if (testCase == 1) {
            System.out.println(quizArr[0]);
            return;
        } else if (testCase == 2) {
            System.out.println(quizArr[0] + quizArr[1]);
            return;
        }

        long answer = 0;

        Arrays.sort(quizArr);

        for (int i = 0; i < testCase; i++) {
            if (i < 2) {
                answer += quizArr[i];
            } else {
                answer = answer * 2 + quizArr[i];
            }
        }

        System.out.println(answer);
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
