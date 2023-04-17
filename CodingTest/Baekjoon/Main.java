package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//배낭 문제
//정답 참고
//https://st-lab.tistory.com/141

//Bottom-Up

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int bagageNums = Integer.parseInt(inputs[0]);
        int maxWeight = Integer.parseInt(inputs[1]);
        int[][] bagages = new int[bagageNums][2];

        final int WEIGHT = 0;
        final int VALUE = 1;

        for (int i = 0; i < bagageNums; i++) {
            inputs = br.readLine().split(" ");
            bagages[i][WEIGHT] = Integer.parseInt(inputs[0]);
            bagages[i][VALUE] = Integer.parseInt(inputs[1]);
        }

        sol.solution(bagages, maxWeight);
    }
}

class BjSolution {
    final int WEIGHT = 0;
    final int VALUE = 1;

    public void solution(int[][] bagages, int maxWeight) {
        int bagageNum = bagages.length;
        int[] dp = new int[maxWeight + 1];

        for (int bagIdx = 1; bagIdx <= bagageNum; bagIdx++) {
            int tempWeight = bagages[bagIdx - 1][WEIGHT];
            int tempValue = bagages[bagIdx - 1][VALUE];

            // K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
            for (int bagLimit = maxWeight; bagLimit - tempWeight >= 0; bagLimit--) {
                dp[bagLimit] = Math.max(dp[bagLimit], dp[bagLimit - tempWeight] + tempValue);
            }
        }

        System.out.println(dp[maxWeight]);
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
