package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//정답 참고 - 문자열 폭발 [9935]
//https://loosie.tistory.com/317

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fl = br.readLine();
        String sl = br.readLine();
        sol.solution(fl, sl);
    }
}

class BjSolution {
    public void solution(String fl, String sl) {
        Stack<Character> st = new Stack<>();
        int slLen = sl.length();

        for (int i = 0; i < fl.length(); i++) {
            st.push(fl.charAt(i));

            //터지는 문자열보다 길이가 길어지면 비교를 시작
            if (st.size() >= slLen) {
                boolean flag = true;
                for (int j = 0; j < slLen; j++) {
                    char stChar = st.get(st.size() - slLen + j);
                    char slChar = sl.charAt(j);
                    if (stChar != slChar) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < slLen; j++) {
                        st.pop();
                    }
                }
            }
        }

        if (st.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : st) {
            sb.append(character);
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
