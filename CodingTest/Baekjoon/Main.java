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
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int day = Integer.parseInt(br.readLine());
            String[] stockPrices = br.readLine().split(" ");

            sol.solution(day, stockPrices);
        }
    }
}

class BjSolution {

    public void solution(int day, String[] stockStrPrices) {
        long answer = 0;
        long max = Long.MIN_VALUE;

        int[] stockIntPrices = new int[stockStrPrices.length];

        for (int idx = 0; idx < stockStrPrices.length; idx++) {
            stockIntPrices[idx] = Integer.parseInt(stockStrPrices[idx]);
        }

        for (int idx = stockIntPrices.length - 1; idx >= 0; idx--) {
            int stockIntPrice = stockIntPrices[idx];

            if (stockIntPrice >= max) {
                max = stockIntPrice;
            } else {
                answer += (max - stockIntPrice);
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
