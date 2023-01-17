package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quizNum = Integer.parseInt(br.readLine());

        sol.solution(quizNum);
    }
}

class BjSolution {
    public void solution(int quizNum) {
        StringBuilder sb = new StringBuilder();

        long digitNum = 1;
        long checkNum = 1;
        long saveNum = 0;

        while (true) {
            checkNum = (1L << digitNum) + saveNum;
            if (quizNum <= checkNum) {
                break;
            }

            digitNum++;
            saveNum = checkNum;
        }

        long newQuizNum = quizNum - saveNum;
        long numCount = 1L << digitNum;

        while (sb.length() != digitNum) {
            long divideNum = numCount / 2;
            if (newQuizNum > divideNum) {
                sb.append(7);
                newQuizNum = newQuizNum - divideNum;
            } else {
                sb.append(4);
            }
            numCount /= 2;
        }

        System.out.println(sb);
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
