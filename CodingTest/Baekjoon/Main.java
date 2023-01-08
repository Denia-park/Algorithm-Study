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
        String fl = br.readLine();
        String sl = br.readLine();
        sol.solution(fl, sl);
    }
}

class BjSolution {
    public void solution(String fl, String sl) {
        Deque<Character> answer = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();

        int slIdx = 0;
        for (int i = 0; i < fl.length(); i++) {
            char fc = fl.charAt(i);
            char sc = sl.charAt(slIdx);

            if (fc != sc) {
                while (!temp.isEmpty()) {
                    answer.addLast(temp.removeFirst());
                }
                slIdx = 0;
                answer.addLast(sc);
                continue;
            }

            temp.addLast(sc);
            slIdx++;
            if (slIdx == sl.length()) {
                temp.clear();
                slIdx = 0;
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
