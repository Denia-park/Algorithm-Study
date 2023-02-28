package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

//https://school.programmers.co.kr/learn/courses/30/lessons/12936

//1번부터 n번까지 줄 서기

class Solution {
    Deque<Integer> list;
    long[] factArr;
    boolean[] isVisited;
    int gCount;
    int[] answer;

    public int[] solution(int n, long k) {
        factArr = new long[n + 1];
        factArr[0] = 1;
        for (int i = 1; i <= n; i++) {
            factArr[i] = (factArr[i - 1] * i);
        }

        isVisited = new boolean[n + 1];
        list = new ArrayDeque<>();

        gCount = 1;

        dfs(n, k, 0);

        return answer;
    }

    private void dfs(int n, long k, int count) {
        if (count == n) {
            if (gCount == k) {
                answer = list.stream().mapToInt(i -> i).toArray();
            }
            gCount++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.addLast(i);
                dfs(n, k, count + 1);
                if (answer != null) return;
                list.removeLast();
                isVisited[i] = false;
            }
        }

    }
}
