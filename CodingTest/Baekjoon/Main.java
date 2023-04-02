package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//23년 4월 2일 오후 4시 8분
//27분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        int tc = Integer.parseInt(l1);
        String l2 = br.readLine();
        int[] iArr = new int[tc];
        int idx = 0;
        for (String str : l2.split(" ")) {
            iArr[idx++] = Integer.parseInt(str);
        }

        sol.solution(iArr);
    }
}

class BjSolution {
    private int[] gArr;
    private boolean[] visited;
    private int ans;

    public void solution(int[] iArr) {
        ans = Integer.MIN_VALUE;
        visited = new boolean[iArr.length];
        gArr = iArr;

        Deque<Integer> deque = new ArrayDeque<>();

        dfs(deque);

        System.out.println(ans);
    }

    private void dfs(Deque<Integer> deque) {
        if (deque.size() == gArr.length) {
            ans = Math.max(ans, calculate(deque));
            return;
        }

        for (int i = 0; i < gArr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            deque.addLast(gArr[i]);
            dfs(deque);
            visited[i] = false;
            deque.removeLast();
        }
    }

    private int calculate(Deque<Integer> deque) {
        int[] arr = new int[deque.size()];

        int idx = 0;
        for (Integer integer : deque) {
            arr[idx++] = integer;
        }

        int result = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            result += Math.abs(arr[i] - arr[i + 1]);
        }

        return result;
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
