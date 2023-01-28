package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int arrNum = Integer.parseInt(input);
        int[] arr = new int[arrNum];
        for (int i = 0; i < arrNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(arrNum, arr);
    }
}

class BjSolution {
    public void solution(int arrNum, int[] arr) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int targetIdx = 0;
        int curValue = 1;

        while (targetIdx != arrNum) {
            int targetVal = arr[targetIdx];

            if (!deque.isEmpty()) {
                if (targetVal == deque.peekLast()) {
                    deque.pollLast();
                    sb.append("-").append("\n");
                    targetIdx++;
                    continue;
                }
            }

            if (targetVal >= curValue) {
                deque.addLast(curValue);
                sb.append("+").append("\n");
                curValue++;
            } else {
                System.out.println("NO");
                return;
            }
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
