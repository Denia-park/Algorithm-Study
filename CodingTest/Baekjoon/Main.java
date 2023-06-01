package CodingTest.Baekjoon;

//N과 M (1) 15649

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int maxNum = Integer.parseInt(splits[0]);
        int numMaxSize = Integer.parseInt(splits[1]);

        sol.solution(maxNum, numMaxSize);
    }
}

/*
아이디어
- 모두 돌아야함 -> 완탐 -> 백트래킹 (N이 작다)
- 방문 체크 & 숫자 넣기
- 백트래킹이니까 벗어나면 방문 체크 풀기 & 숫자 빼기

- 출력
순서에 맞게 쭉 출력하기.

시간복잡도
- O(N^사이즈)

자료구조
- 완탐
 */

class BjSolution {
    StringBuilder sb;
    Deque<Integer> dq;
    boolean[] visited;

    public void solution(int maxNum, int numMaxSize) {
        visited = new boolean[maxNum + 1];
        dq = new ArrayDeque<>();
        sb = new StringBuilder();

        backTracking(maxNum, numMaxSize);

        System.out.println(sb);
    }

    private void backTracking(int maxNum, int numMaxSize) {
        if (dq.size() == numMaxSize) {
            print(dq);
            return;
        }

        for (int i = 1; i <= maxNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dq.addLast(i);
                backTracking(maxNum, numMaxSize);
                dq.removeLast();
                visited[i] = false;
            }
        }
    }

    private void print(Deque<Integer> dq) {
        for (Integer val : dq) {
            sb.append(val);
            sb.append(" ");
        }
        sb.append("\n");
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
