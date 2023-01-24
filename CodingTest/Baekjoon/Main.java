package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        sol.solution(input);
    }
}

class BjSolution {
    public void solution(String input) {
        int level = 0;
        long ans = 0;

        String newInput = input.replace("()", ".");

        for (int i = 0; i < newInput.length(); i++) {
            char c = newInput.charAt(i);

            if (c == '.') {
                ans += level;
            } else if (c == '(') {
                level += 1;
            } else if (c == ')') {
                level -= 1;
                ans += 1;
            }
        }
        System.out.println(ans);
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
