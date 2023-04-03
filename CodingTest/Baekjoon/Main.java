package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//23년 4월 3일 오후 1시 25분
//10분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tcn = Integer.parseInt(br.readLine());
        String[] strArr = new String[tcn];
        for (int i = 0; i < tcn; i++) {
            strArr[i] = br.readLine();
        }

        sol.solution(strArr);
    }
}

class BjSolution {
    public void solution(String[] strArr) {
        for (String str : strArr) {
            if (isVPS(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();

                if (top == ')') {
                    return false;
                }

                if (c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
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
