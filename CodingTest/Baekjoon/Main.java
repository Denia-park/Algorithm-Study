package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while ((input = br.readLine()) != null) {
            sol.solution(input);
        }
    }
}

class BjSolution {
    public void solution(String input) {
        int small = 0, big = 0, num = 0, space = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                num++;
            } else if (c == ' ') {
                space++;
            } else if (c >= 'a' && c <= 'z') {
                small++;
            } else if (c >= 'A' && c <= 'Z') {
                big++;
            }
        }

        System.out.println("" + small + " " + big + " " + num + " " + space);
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
