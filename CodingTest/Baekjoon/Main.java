package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sol.solution(br.readLine());
    }
}

class BjSolution {
    public void solution(String inputVal) {
        int ans = 0;

        if (inputVal.length() == 1) {
            System.out.println(Integer.parseInt(inputVal));
            return;
        }

        if (inputVal.startsWith("0")) {
            if (inputVal.charAt(1) == 'x') {
                ans = Integer.parseInt(inputVal.substring(2), 16);
            } else {
                ans = Integer.parseInt(inputVal, 8);
            }
        } else {
            ans = Integer.parseInt(inputVal, 10);
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
