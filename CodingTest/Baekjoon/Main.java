package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<String> answers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int targetIdx = 0;
        int curValue = 1;

        while (targetIdx != arrNum) {
            int targetVal = arr[targetIdx];

            if (!stack.isEmpty()) {
                if (targetVal == stack.peek()) {
                    stack.pop();
                    answers.add("-");
                    targetIdx++;
                    continue;
                }
            }

            if (targetVal >= curValue) {
                stack.push(curValue);
                answers.add("+");
                curValue++;
            } else {
                System.out.println("NO");
                return;
            }
        }

        for (String answer : answers) {
            System.out.println(answer);
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
