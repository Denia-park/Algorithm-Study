package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int day = Integer.parseInt(br.readLine());
            String[] stockPrices = br.readLine().split(" ");

            sol.solution(day, stockPrices);
        }

    }
}

class BjSolution {

    public void solution(int day, String[] stockStrPrices) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int[] stockIntPrices = new int[stockStrPrices.length];
        for (int idx = 0; idx < stockStrPrices.length; idx++) {
            int i1 = Integer.parseInt(stockStrPrices[idx]);
            stockIntPrices[idx] = i1;
            pq.offer(i1);
        }

        Deque<Integer> list = new ArrayDeque<>();

        for (int idx = 0; idx < day; idx++) {
            int curVal = stockIntPrices[idx];
            if (curVal == pq.peek()) {
                while (!list.isEmpty()) {
                    answer += (curVal - list.poll());
                }
                pq.poll();
            } else {
                list.addLast(curVal);
            }
        }

        System.out.println(answer);
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
