package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 23년 4월 5일 오후 2시 57분
// 8분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        sol.solution(inputs);
    }
}

class BjSolution {
    public void solution(String[] inputs) {
        int[] intInputs = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        int num = intInputs[0];
        int count = intInputs[1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= num; i++) {
            deque.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int deleteCount = 0;
        while (deque.size() != 1) {
            int val = deque.removeFirst();
            deleteCount++;
            if (deleteCount == count) {
                sb.append(val).append(", ");
                deleteCount = 0;
            } else {
                deque.addLast(val);
            }
        }

        sb.append(deque.removeFirst()).append(">");

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
