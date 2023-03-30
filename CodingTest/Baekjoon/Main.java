package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            sol.solution(br.readLine());
        }
    }
}


class BjSolution {
    public void solution(String input) {
        String[] inputs = input.split(" ");
        int mutiplyValue = Integer.parseInt(inputs[0]);
        char[] chars = inputs[1].toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            for (int i = 0; i < mutiplyValue; i++) {
                sb.append(ch);
            }
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
