package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//동전 1 [2293]
//정답 참고 : https://yabmoons.tistory.com/491

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int coinCount = Integer.parseInt(input[0]);
        int totalValue = Integer.parseInt(input[1]);

        int[] coinValues = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coinValues[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(coinCount, totalValue, coinValues);
    }
}

class BjSolution {
    public void solution(int coinCount, int totalValue, int[] coinValues) {
        int[] dp = new int[totalValue + 1];

        dp[0] = 1; // 0원을 만드는 경우는 1개

        for (int coinIdx = 0; coinIdx < coinCount; coinIdx++) {
            int curCoin = coinValues[coinIdx];
            for (int curValue = curCoin; curValue < totalValue + 1; curValue++) {
                // 이전에 다른 코인들로 만들어둔 경우의 수 +
                // 이번에 사용할 코인으로 만들수 있는 경우의 수
                // [ = 현재 사용할 코인 값을 추가해서 만들수 있는 경우 이므로 현재 값에서 - 현재 코인 값을 뺐을 때의 경우를 그대로 가져오면 된다.]
                dp[curValue] = dp[curValue] + dp[curValue - curCoin];
            }
        }

        System.out.println(dp[totalValue]);
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
