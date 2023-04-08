package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int coninNum = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        int[] coins = new int[coninNum];
        for (int i = 0; i < coninNum; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(coins, target);
    }
}

class BjSolution {

    public void solution(int[] coins, int target) {
        int answer = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];

            if (coin > target) continue;

            int count = target / coin;
            target -= count * coin;

            answer += count;
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
