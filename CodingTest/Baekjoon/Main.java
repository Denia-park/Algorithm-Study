package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//23년 4월 5일 오후 1시 15분
// 31분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] inputs = br.readLine().split(" ");

        sol.solution(inputs);
    }
}

class BjSolution {
    public void solution(String[] inputs) {
        int[] answer = new int[inputs.length];

        Deque<int[]> deque = new ArrayDeque<>();

        int[] intInputs = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();

        for (int arrIdx = 0; arrIdx < intInputs.length; arrIdx++) {
            int myTowerIdx = arrIdx + 1;
            int curHeight = intInputs[arrIdx];

            if (deque.isEmpty()) {
                deque.push(new int[]{myTowerIdx, curHeight});
                continue;
            }

            while (!deque.isEmpty()) {
                int[] top = deque.peek();
                int topTowerIdx = top[0];
                int topHeight = top[1];

                if (topHeight >= curHeight) {
                    answer[arrIdx] = topTowerIdx;
                    break;
                } else {
                    deque.pop();
                }
            }

            deque.push(new int[]{myTowerIdx, curHeight});
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
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
