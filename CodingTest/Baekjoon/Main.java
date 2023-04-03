package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//23년 4월 3일 오후 1시 37분
//6분 걸림

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
        List<Integer> arr = Arrays.stream(strArr).map(Integer::parseInt).collect(Collectors.toList());

        Stack<Integer> stack = new Stack<>();
        stack.addAll(arr);

        int ans = 1;
        int top = stack.pop();
        while (!stack.isEmpty()) {
            int curTop = stack.pop();
            if (curTop <= top) {
                continue;
            }

            top = curTop;
            ans++;
        }

        System.out.println(ans);
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
