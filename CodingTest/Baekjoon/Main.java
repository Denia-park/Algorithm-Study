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
        int comNum = Integer.parseInt(br.readLine());
        int pairNum = Integer.parseInt(br.readLine());

        int[][] table = new int[pairNum][2];

        for (int r = 0; r < pairNum; r++) {
            String[] row = br.readLine().split(" ");
            for (int i = 0; i < 2; i++) {
                table[r][i] = Integer.parseInt(row[i]);
            }
        }

        sol.solution(comNum, pairNum, table);
    }
}

class BjSolution {
    boolean[] isVisited;
    List<List<Integer>> graph;
    int answer;


    public void solution(int comNum, int pairNum, int[][] table) {
        answer = -1;
        graph = new ArrayList<>();
        isVisited = new boolean[comNum + 1];

        for (int i = 0; i < comNum + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int r = 0; r < pairNum; r++) {
            int start = table[r][0];
            int end = table[r][1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs();

        System.out.println(answer);
    }

    private void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        isVisited[1] = true;
        dq.addLast(1);

        while (!dq.isEmpty()) {
            int curNum = dq.pollFirst();
            answer++;

            for (int nextNum : graph.get(curNum)) {
                if (!isVisited[nextNum]) {
                    isVisited[nextNum] = true;
                    dq.addLast(nextNum);
                }
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
