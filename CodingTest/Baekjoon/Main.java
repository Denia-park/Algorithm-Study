package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//주식
//정답 참고
//https://velog.io/@ehdcks3421/%EB%B0%B1%EC%A4%80-%EC%A3%BC%EC%8B%9D-11501

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputVal = Integer.parseInt(br.readLine());

        sol.solution(inputVal);
    }
}

class BjSolution {
    int[] coins = {500, 100, 50, 10, 5, 1};

    public void solution(int inputVal) {
        int answer = 0;

        int restVal = 1000 - inputVal;

        for (int coin : coins) {
            if (restVal > coin) {
                int mod = restVal / coin;
                restVal -= mod * coin;
                answer += mod;
            }
        }

        System.out.println(answer);
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
