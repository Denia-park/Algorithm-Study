package CodingTest.Baekjoon;

//N과 M- 15649

//계획
//백트래킹
//순열 문제 - DFS

//출력
//사전 순으로 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        sol.solution(n, m);
    }
}

class BjSolution {
    StringBuilder sb;
    int maxValue;
    int countLimit;
    boolean[] isVisited;

    public void solution(int n, int m) {
        sb = new StringBuilder();
        maxValue = n;
        countLimit = m;
        isVisited = new boolean[n + 1];


        dfs(0, new ArrayDeque<>());

        System.out.println(sb);
    }

    private void dfs(int curCount, Deque<Integer> dq) {
        if (curCount == countLimit) {
            for (Integer val : dq) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int idx = 1; idx <= maxValue; idx++) {
            if (isVisited[idx]) continue;

            isVisited[idx] = true;
            dq.addLast(idx);
            dfs(curCount + 1, dq);
            isVisited[idx] = false;
            dq.removeLast();
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
