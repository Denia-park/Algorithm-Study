package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("0")) {
                break;
            }

            sol.solution(line);
            System.out.println();
        }
    }
}

class BjSolution {
    Deque<String> queue;
    String[] gQuiz;

    public void solution(String[] quiz) {
        gQuiz = quiz;
        queue = new ArrayDeque<>();
        int numCount = Integer.parseInt(quiz[0]);
        String[] numbers = new String[numCount];
        for (int i = 1; i < 7; i++) {
            numbers[i] = quiz[i];
        }

        dfs(0, queue);
    }

    private void dfs(int depth, Deque<String> queue) {
        if (depth == 7) {
            StringBuilder sb = new StringBuilder();
            List<String> tempList = new ArrayList<>(queue);

            for (String integer : tempList) {
                sb.append(integer).append(" ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = depth + 1; i < 7; i++) {
            queue.addLast(gQuiz[i]);
            dfs(i + 1, queue);
            queue.removeLast();
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
