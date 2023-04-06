package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 23년 4월 6일 오전 12시 03분
// 5분 걸림 -- 이전에 몇번 풀어본 문제

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] inputs = new int[tc];
        for (int i = 0; i < tc; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(inputs);
    }
}

class BjSolution {
    public void solution(int[] inputs) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : inputs) {
            queue.add(i);
        }

        int answer = 0;

        while (queue.size() != 1) {
            int first = queue.poll();
            int second = queue.poll();

            int tempSum = (first + second);
            answer += tempSum;

            queue.add(tempSum);
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
