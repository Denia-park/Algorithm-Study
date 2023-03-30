package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        sol.solution(input);
    }
}


class BjSolution {
    public void solution(String input) {
        int[] inputs = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = inputs[0];
        int y = inputs[1];
        int w = inputs[2];
        int h = inputs[3];

        int up = h - y;
        int down = y;
        int left = x;
        int right = w - x;

        int[] values = new int[]{up, down, left, right};
        System.out.println(Arrays.stream(values).min().getAsInt());
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
