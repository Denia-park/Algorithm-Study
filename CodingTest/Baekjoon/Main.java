package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 23년 4월 5일 오후 3시 6분
// 32분 걸림

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
        PriorityQueue<Integer> leftMaxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinPq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        leftMaxPq.add(inputs[0]);
        sb.append(inputs[0]).append("\n");

        for (int idx = 1; idx < inputs.length; idx++) {
            int curr = inputs[idx];
            int count = idx + 1;

            //짝수
            if (count % 2 == 0) {
                int addVal = curr;

                if (leftMaxPq.peek() > curr) {
                    addVal = leftMaxPq.remove();
                    leftMaxPq.add(curr);
                }

                rightMinPq.add(addVal);
            }
            //홀수
            else {
                int addVal = curr;

                if (rightMinPq.peek() < curr) {
                    addVal = rightMinPq.remove();
                    rightMinPq.add(curr);
                }

                leftMaxPq.add(addVal);
            }

            sb.append(leftMaxPq.peek()).append("\n");
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
