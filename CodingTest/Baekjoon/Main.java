package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();

        sol.solution(firstLine);
    }
}

class BjSolution {
    int answer;

    public void solution(String firstLine) {
        char[] arr = firstLine.toCharArray();

        if (!isRightValue(arr)) {
            System.out.println(0);
            return;
        }

        int result = 0;
        int tempValue = 1;
        char lastChar = ' ';
        for (char c : arr) {
            if (c == '(') {
                tempValue *= 2;
            } else if (c == '[') {
                tempValue *= 3;
            } else if (c == ')') {
                if (lastChar == '(') {
                    result += tempValue;
                }
                tempValue /= 2;
            } else if (c == ']') {
                if (lastChar == '[') {
                    result += tempValue;
                }
                tempValue /= 3;
            }

            lastChar = c;
        }

        System.out.println(result);
    }

    private boolean isRightValue(char[] arr) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (deque.isEmpty()) {
                deque.push(c);
                continue;
            }

            if (c == '(' || c == '[') {
                deque.push(c);
            } else if (c == ')') {
                if (deque.peekFirst() == '(') {
                    deque.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (deque.peekFirst() == '[') {
                    deque.pop();
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
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
