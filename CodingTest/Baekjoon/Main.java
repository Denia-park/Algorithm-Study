package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputVal = Integer.parseInt(br.readLine());

        sol.solution(inputVal);
    }
}

class BjSolution {
    int[] seconds = {300, 60, 10};

    public void solution(int inputVal) {
        int[] answer = new int[seconds.length];


        for (int i = 0; i < seconds.length; i++) {
            if (inputVal >= seconds[i]) {
                int mod = inputVal / seconds[i];
                inputVal -= (seconds[i] * mod);
                answer[i] = mod;
            }
        }

        if (inputVal == 0) {
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
        } else {
            System.out.println(-1);
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
