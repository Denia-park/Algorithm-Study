package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = new int[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        sol.solution(inputs);
    }
}


class BjSolution {
    public void solution(int[] input) {
        long multiplyValue = (long) input[0] * input[1] * input[2];
        String str = String.valueOf(multiplyValue);
        int[] output = new int[10];
        for (char ch : str.toCharArray()) {
            output[ch - '0']++;
        }
        for (int i : output) {
            System.out.println(i);
        }
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
