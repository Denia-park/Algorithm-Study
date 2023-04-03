package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//23년 4월 3일 오후 1시 58분
//5분 걸림

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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int input : inputs) {
            if (input == 0) {
                int val = 0;

                if (!pq.isEmpty()) {
                    val = pq.poll();
                }

                System.out.println(val);
            } else {
                pq.offer(input);
            }
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
