package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//23년 4월 2일 오전 12시 48분
//14분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sol.solution(br.readLine());
    }
}


class BjSolution {
    public void solution(String input) {
        int val = Integer.parseInt(input);

        if (val < 100) {
            System.out.println(val);
            return;
        }

        int ans = 99;

        for (int i = 100; i <= val; i++) {
            String str = String.valueOf(i);

            int diff = (str.charAt(0) - '0') - (str.charAt(1) - '0');
            boolean flag = true;
            for (int j = 1; j < str.length() - 1; j++) {
                char c = str.charAt(j);
                char nc = str.charAt(j + 1);
                if (diff != (c - '0') - (nc - '0')) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
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
