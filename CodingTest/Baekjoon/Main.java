package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//배낭 문제
//정답 참고
//https://st-lab.tistory.com/141

//Top - Down

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
    Integer[][] dp;
    int[][] gBagages;

    public void solution(int[][] bagages, int maxWeight) {
        gBagages = bagages;
        int bagageNum = bagages.length;
        dp = new Integer[bagageNum][maxWeight + 1];
        System.out.println(knapsack(bagageNum - 1, maxWeight));
    }

    private int knapsack(int bagageIdx, int maxWeight) {
        //bagageIdx가 0미만, 즉 범위 밖이면
        if (bagageIdx < 0) {
            return 0;
        }

        //탐색하지 않은 위치면?
        if (dp[bagageIdx][maxWeight] == null) {
            //현재 물건(bagageIdx)를 추가로 못 담는 경우 (이전 bagageIdx값 탐색)
            if (gBagages[bagageIdx][WEIGHT] > maxWeight) {
                dp[bagageIdx][maxWeight] = knapsack(bagageIdx - 1, maxWeight);
            }
            //현재 물건(bagageIdx)를 담을 수 있는 경우
            else {
                // 이전 bagageIdx값과 이전 bagageIdx값에 대한 k-W[bagageIdx]의 값 + 현재 가치(V[bagageIdx])중 큰 값을 저장
                dp[bagageIdx][maxWeight] = Math.max(knapsack(bagageIdx - 1, maxWeight), knapsack(bagageIdx - 1, maxWeight - gBagages[bagageIdx][WEIGHT]) + gBagages[bagageIdx][VALUE]);
            }
        }

        return dp[bagageIdx][maxWeight];
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
