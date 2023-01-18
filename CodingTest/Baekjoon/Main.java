package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");

            sol.solution(input);
        }
    }
}

class BjSolution {
    public void solution(String[] quizNum) {
        StringBuilder sb = new StringBuilder();

        int rowMax = Integer.parseInt(quizNum[0]);
        int target = Integer.parseInt(quizNum[2]);

        int floor = target % rowMax;
        if (floor == 0) floor = rowMax;

        int width = ((target - 1) / rowMax) + 1;

        sb.append(floor).append(width < 10 ? 0 : "").append(width);

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
