package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정답 참고
//https://velog.io/@jxlhe46/%EB%B0%B1%EC%A4%80-2293%EB%B2%88.-%EB%8F%99%EC%A0%84-1-bfi120m5

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            br.readLine();
            String[] coins = br.readLine().split(" ");
            String target = br.readLine();

            sol.solution(coins, target);
        }
    }
}

class BjSolution {
    public void solution(String[] coins, String target) {
        int intTarget = Integer.parseInt(target);
        int[] dp = new int[intTarget + 1];

        dp[0] = 1;

        for (String coin : coins) {
            int intCoin = Integer.parseInt(coin);

            for (int val = intCoin; val <= intTarget; val++) {
                dp[val] += dp[val - intCoin];
            }
        }

        System.out.println(dp[intTarget]);
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
