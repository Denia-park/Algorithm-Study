package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int[] nums = new int[inputCount];
        for (int i = 0; i < inputCount; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        sol.solution(input, nums);
    }
}

class BjSolution {

    public void solution(String originInput, int[] nums) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < originInput.length(); i++) {
            char ch = originInput.charAt(i);

            //영문자인 경우 값으로 바꿔서 Stack에 push
            if (isCapitalLetter(ch)) {
                stack.push((double) nums[ch - 'A']);
            } else {
                //계산식인 경우
                double rearVal = stack.pop();
                double frontVal = stack.pop();
                double finalVal = 0;

                if (ch == '+') {
                    finalVal = frontVal + rearVal;
                } else if (ch == '-') {
                    finalVal = frontVal - rearVal;
                } else if (ch == '*') {
                    finalVal = frontVal * rearVal;
                } else if (ch == '/') {
                    finalVal = frontVal / rearVal;
                }

                stack.push(finalVal);
            }
        }

        System.out.printf("%.2f", stack.peek());
    }

    private boolean isCapitalLetter(char c) {
        return c >= 'A' && c <= 'Z';
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
