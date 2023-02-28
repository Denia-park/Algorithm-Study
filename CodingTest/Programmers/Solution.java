package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

//https://school.programmers.co.kr/learn/courses/30/lessons/12936

//1번부터 n번까지 줄 서기

class Solution {
    Deque<Integer> list;
    long[] factArr;
    long gCount;
    int[] answer;
    boolean[] isVisited;

    public int[] solution(int n, long k) {
        factArr = new long[n + 1];
        factArr[n - 1] = 1;
        for (int i = n - 2, j = 2; i >= 0; i--, j++) {
            factArr[i] = (factArr[i + 1] * j);
        }

        list = new ArrayDeque<>();
        answer = new int[n];
        isVisited = new boolean[n + 1];

        gCount = 1;


        dfs(n, k, 1);

        return answer;
    }

    private void dfs(int n, long k, int count) {
        if (count == n + 1) {
            answer = list.stream().mapToInt(i -> i).toArray();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (factArr[count] == 0 || gCount <= k && k < gCount + factArr[count]) {
                if (isVisited[i]) continue;
                isVisited[i] = true;
                list.addLast(i);
                dfs(n, k, count + 1);
                if (answer != null) return;
            } else {
                gCount += factArr[count];
            }
        }

    }
}
