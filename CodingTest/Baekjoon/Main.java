package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String quizString = br.readLine();
        String quiz = br.readLine();

        sol.solution(quizString, quiz);
    }
}

class BjSolution {

    public void solution(String quizString, String quiz) {
        String splitStr = quizString.replace(quiz, "*");

        int idx = -1;
        int answer = 0;

        while (true) {
            idx = splitStr.indexOf("*", idx + 1);
            if (idx == -1) {
                break;
            }

            answer++;
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
