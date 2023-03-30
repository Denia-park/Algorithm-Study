package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int maxVal = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            if (maxVal < val) {
                maxVal = val;
                idx = i;
            }
        }
        System.out.println(maxVal);
        System.out.println(idx + 1);

//        sol.solution(firstLine, secondLine);
    }
}


class BjSolution {
    public void solution(String firstLine, String secondLine) {
        int standard = Integer.parseInt(firstLine.split(" ")[1]);
        int[] arr = Arrays.stream(secondLine.split(" "))
                .mapToInt(Integer::parseInt)
                .filter(i -> i < standard)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
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
