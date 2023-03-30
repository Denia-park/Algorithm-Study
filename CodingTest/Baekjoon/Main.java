package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sol.solution(br.readLine());
    }
}


class BjSolution {
    public void solution(String input) {
        String[] inputs = input.split(" ");
        StringBuilder sb = new StringBuilder();
        int[] answers = new int[2];
        int idx = 0;
        for (String str : inputs) {
            answers[idx] = Integer.parseInt(sb.append(str).reverse().toString());
            idx++;
            sb.setLength(0);
        }

        System.out.println(Math.max(answers[0], answers[1]));
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
